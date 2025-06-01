package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.ClientDTO;
import IFMG_LuizEduardo_RenatoZampiere.entities.Client;
import IFMG_LuizEduardo_RenatoZampiere.repository.ClientRepository;
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
        List ret = clientRepository.findAll();
        for (Object iten: ret){
            System.out.println(iten);
        }
    }

    @Transactional(readOnly = true)
    public void findById(){
        // todo

    }

    @Transactional
    public void insert(ClientDTO dto){
        //String phone, String name, String userName, String passWor
        Client client = new Client(dto.getPhone(), dto.getName(), dto.getUserName(), dto.getPassWord());
        clientRepository.save(client);
    }

    @Transactional
    public void update(Long id, ClientDTO dto){

        try {
            Client client = clientRepository.getReferenceById(id);
            client.setName(dto.getName());
            client.setPhone(dto.getPhone());
            client.setPassWord(dto.getPassWord());
            client.setUserName(dto.getUserName());
        } catch (EntityNotFoundException e){
            System.out.println("Achei não kkkkk"); // todo mudar dps
        }
    }

    @Transactional
    public void delete(Long id){
        if(!clientRepository.existsById(id)){
            System.out.println("nem existe kkkkk"); // todo mudar dps
        }

        try {
            clientRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            System.out.println("Bugou aq kkkkkk"); // todo mudar dps
        }
    }




}
