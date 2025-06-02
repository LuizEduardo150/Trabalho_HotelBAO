package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.repository.StaysRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaysService {

    @Autowired
    private StaysRepository staysRepository;

    @Transactional(readOnly = true)
    public void findAll(){ // todo mudar dps o que faz
        List ret = staysRepository.findAll();
        for (Object iten: ret){
            System.out.println(iten);
        }
    }

    @Transactional(readOnly = true)
    public void findById(Long id){
        staysRepository.findById(id);

    }

    @Transactional
    public void insert(StaysDTO dto){
        staysRepository.save(new Stays(dto));
    }

    @Transactional
    public void update(Long id, StaysDTO dto){

        try {//todo conferir algumas regras de ngc
            Stays stays = staysRepository.getReferenceById(id);
            User u = new User();
            u.setId(dto.getUserId());
            stays.setUserId(u);
            stays.setRoomId(dto.getRoomId());
            stays.setStart(dto.getStart());
            stays.setEnd(dto.getEnd());
            stays.setEntryTime(dto.getEntryTime());
            stays.setDepartureTime(dto.getDepartureTime());
            stays.setTotalCost(dto.getTotalCost());

        } catch (EntityNotFoundException e){
            System.out.println("Achei não kkkkk"); // todo mudar dps
        }
    }

    @Transactional
    public void delete(Long id){
        if(!staysRepository.existsById(id)){
            System.out.println("nem existe kkkkk"); // todo mudar dps
        }

        try {
            staysRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            System.out.println("Bugou aq kkkkkk"); // todo mudar dps
        }
    }




}
