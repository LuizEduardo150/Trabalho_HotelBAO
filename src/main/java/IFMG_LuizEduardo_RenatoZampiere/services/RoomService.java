package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.RoomDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import IFMG_LuizEduardo_RenatoZampiere.repository.RoomRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.DataBaseException;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Transactional(readOnly = true)
    public List<RoomDTO> findAll(){
        List<Room> roomList = roomRepository.findAll();
        List<RoomDTO> dto = new ArrayList<>();

        for (Room room : roomList){
            dto.add(new RoomDTO(room));
        }

        return dto;
    }

    @Transactional(readOnly = true)
    public RoomDTO findById(Long id){
        Optional<Room> obj = roomRepository.findById(id);
        Room room = obj.orElseThrow(()-> new ResourceNotFound("Quarto não encontrado: " + id));

        return new RoomDTO(room);
    }

    @Transactional
    public void insert(RoomDTO dto){
        try {
            roomRepository.save(new Room(dto));
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha ao adicionar quarto, verifique os tipos de dado");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Transactional
    public void delteById(Long id){
        if (!roomRepository.existsById(id)){
            System.out.println("nem Existe");
            throw new ResourceNotFound("Não existe quarto cadastrado com o ID: "+ id);
        }

        roomRepository.deleteById(id);
    }

    @Transactional
    public void updateById(Long id, RoomDTO dto){
        try {
            Room room = roomRepository.getReferenceById(id);

            room.setName(dto.getName());
            room.setPrice(new BigDecimal(dto.getPrice()));
            room.setNumberOfBeds(dto.getNumberOfBeds());
            room.setScore(dto.getScore());

        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFound("ERRO: Não existe quarto cadastrado com ID: " + id);
        }
    }

}
