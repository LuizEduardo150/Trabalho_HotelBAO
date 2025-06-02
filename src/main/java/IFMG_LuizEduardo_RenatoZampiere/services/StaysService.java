package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;
import IFMG_LuizEduardo_RenatoZampiere.repository.StaysRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void findById(){
        // todo

    }

    @Transactional
    public void insert(StaysDTO dto){
        //String phone, String name, String userName, String passWor

        staysRepository.save(new Stays()); // todo
    }

    @Transactional
    public void update(Long id, StaysDTO dto){

        try {//todo setar statys values
            Stays stays = staysRepository.getReferenceById(id);

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
