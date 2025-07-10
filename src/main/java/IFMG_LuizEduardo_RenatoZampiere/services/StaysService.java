package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDetailedWithoutUserDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysUserDetailedDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.projections.StaysDetailedWithoutUserDataProjection;
import IFMG_LuizEduardo_RenatoZampiere.projections.StaysUserDetailedProjection;
import IFMG_LuizEduardo_RenatoZampiere.repository.RoomRepository;
import IFMG_LuizEduardo_RenatoZampiere.repository.StaysRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.DataBaseException;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StaysService {

    @Autowired
    private StaysRepository staysRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<StaysDTO> findAll(){

        List<Stays> ret = staysRepository.findAll();
        List <StaysDTO> dto = ret.stream().map((stay) -> new StaysDTO(stay)).toList();

        return dto;
    }

    @Transactional(readOnly = true)
    public List<StaysUserDetailedDTO> findAllDetailed(){

        List<StaysUserDetailedProjection> list = staysRepository.getAllStaysDetailed();
        List<StaysUserDetailedDTO> dtoList = new ArrayList<>();

        for (StaysUserDetailedProjection stay : list){
            StaysUserDetailedDTO dto = new StaysUserDetailedDTO();
            dto.setId(stay.getId());
            dto.setUserId(stay.getUserId());
            dto.setRoomId(stay.getRoomId());
            dto.setRoomName(stay.getRoomName());
            dto.setClientName(stay.getClientName());
            dto.setClientPhone(stay.getClientPhone());
            dto.setClientEmail(stay.getClientEmail());
            dto.setStartStay(stay.getStartStay());
            dto.setEndStay(stay.getEndStay());
            dto.setTotalCost(stay.getTotalCost());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Transactional(readOnly = true)
    public List<StaysDTO> getStaysOfRoomById(Long roomId){

        List<Stays> list = staysRepository.getStaysOfRoomById(roomId);

        return list.stream().map(StaysDTO::new).toList();
    }


    @Transactional(readOnly = true)
    public StaysDTO findById(Long id){

        Optional <Stays> opt = staysRepository.findById(id);
        Stays ret = opt.orElseThrow(() -> new ResourceNotFound("Estadia não encontrada: " + id));

        return new StaysDTO(ret);
    }

    @Transactional(readOnly = true)
    public List<StaysDetailedWithoutUserDataDTO> getStaysDetailedWithoutUserData(Long id){
        List<StaysDetailedWithoutUserDataProjection> list = staysRepository.getStaysDetailedWithoutUserData(id);
        List<StaysDetailedWithoutUserDataDTO> dtoList = new ArrayList<>();

        for (StaysDetailedWithoutUserDataProjection proj : list){
            StaysDetailedWithoutUserDataDTO dto = new StaysDetailedWithoutUserDataDTO();

            dto.setRoomName(proj.getRoomName());
            dto.setScore(proj.getScore());
            dto.setRoomCost(proj.getRoomCost());
            dto.setTotalStayCost(proj.getTotalStayCost());
            dto.setStartStay(proj.getStartStay());
            dto.setEndStay(proj.getEndStay());

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Transactional
    public void insert(StaysDTO dto){
        // Condicao ilegal: inicio dps do fim ou inicio antes da data atual
        if( dto.getStartStay().isAfter(dto.getEndStay()) || dto.getStartStay().isBefore(LocalDate.now()))
            throw new DataBaseException("Datas inválidas para reserva");

        BigDecimal price = roomRepository.getRoomPriceById(dto.getRoomId());

        if (price == null)
            throw new DataBaseException("Quarto nao encontrado");

        // Calcular custo total
        long days = ChronoUnit.DAYS.between(dto.getStartStay(), dto.getEndStay());
        BigDecimal total = price.multiply(BigDecimal.valueOf(days));
        dto.setTotalCost(total);

        // Verificar Colisão:
        List<Long> lista = staysRepository.getRoomStaysIdBetweenDates(dto.getRoomId(), dto.getStartStay(), dto.getEndStay());

        if(!lista.isEmpty())
            throw new DataBaseException("Colisão de Datas!");

        try {
            staysRepository.save(new Stays(dto));
        } catch (DataIntegrityViolationException e) {
            System.out.println("Falha ao adicionar estadia, verifique os tipos de dado");
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    @Transactional
    public void update(Long id, StaysDTO dto){
        /*
        * Por escolha, decidi que pode ser alterado apenas a data de início e fim. Quarto e clientes n podem ser alterados
        * */
        List<Long> lista = staysRepository.getRoomStaysIdBetweenDates(dto.getRoomId(), dto.getStartStay(), dto.getEndStay());

        if(!lista.isEmpty()){ // colisão
            for(Long id_i : lista){
                if (id != id_i){ // Só pode colidir consigo mesmo
                    throw new DataBaseException("Datas Dolidem !");
                }
            }
        }

        BigDecimal price = roomRepository.getRoomPriceById(dto.getRoomId());

        if (price == null)
            throw new DataBaseException("Quarto nao encontrado");

        // Calcular custo total
        long days = ChronoUnit.DAYS.between(dto.getStartStay(), dto.getEndStay());
        BigDecimal total = price.multiply(BigDecimal.valueOf(days));
        dto.setTotalCost(total);

        try {
            Stays stays = staysRepository.getReferenceById(id);
            stays.setStartStay(dto.getStartStay());
            stays.setEndStay(dto.getEndStay());
            stays.setTotalCost(total);
        } catch (EntityNotFoundException e){
            throw new DataBaseException("Não existe estadia cadastrada com o ID: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha ao atualizar estadia, verifique os tipos de dado");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Transactional
    public void delete(Long id){
        if(!staysRepository.existsById(id)){
            throw new ResourceNotFound("Não existe estadia cadastrada com o ID: " + id);
        }

        try {
            staysRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Falha ao deletar estadia, verifique se a estadia está vinculada a outros registros");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Transactional(readOnly = true)
    public List<StaysUserDetailedDTO> getStaysUserId(Long userId){

        List<StaysUserDetailedProjection> list = staysRepository.getStaysUserId(userId);

        List<StaysUserDetailedDTO> dtoList = new ArrayList<>();

        for (StaysUserDetailedProjection stay : list){
            StaysUserDetailedDTO dto = new StaysUserDetailedDTO();
            dto.setId(stay.getId());
            dto.setUserId(stay.getUserId());
            dto.setRoomId(stay.getRoomId());
            dto.setRoomName(stay.getRoomName());
            dto.setClientName(stay.getClientName());
            dto.setClientPhone(stay.getClientPhone());
            dto.setClientEmail(stay.getClientEmail());
            dto.setStartStay(stay.getStartStay());
            dto.setEndStay(stay.getEndStay());
            dto.setTotalCost(stay.getTotalCost());

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Transactional
    public void deleAllStays(){
        staysRepository.deleteAll();
    }



}
