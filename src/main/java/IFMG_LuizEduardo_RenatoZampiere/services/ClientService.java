package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.ClientDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ClientService {

    @Transactional(readOnly = true)
    public void findAll(){
        // todo

    }

    @Transactional(readOnly = true)
    public void findById(){
        // todo

    }

    @Transactional
    public void insert(ClientDTO dto){
        // todo

    }

    @Transactional
    public void update(ClientDTO dto){
        // todo

    }

    @Transactional
    public void delete(ClientDTO dto){
        // todo
    }






}
