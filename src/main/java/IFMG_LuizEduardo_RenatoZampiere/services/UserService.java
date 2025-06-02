package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public void findAll(){ // todo mudar dps o que faz
        List ret = userRepository.findAll();
        for (Object iten: ret){
            System.out.println(iten);
        }
    }

    @Transactional(readOnly = true)
    public void findById(){
        // todo

    }

    @Transactional
    public void insert(UserDTO dto){
        System.out.println("Um isert");
        userRepository.save(new User(dto));
        System.out.println("fim isnert");
    }

    @Transactional
    public void update(Long id, UserDTO dto){

        try {
            User user = userRepository.getReferenceById(id);

            user.setUserName(dto.getUserName());
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setRealName(dto.getRealName());
            user.setAddress(dto.getAddress());
            user.setAddressNumber(dto.getAddressNumber());
            user.setDistrict(dto.getDistrict());

        } catch (EntityNotFoundException e){
            System.out.println("Achei não kkkkk"); // todo mudar dps
        }
    }

    @Transactional
    public void delete(Long id){
        if(!userRepository.existsById(id)){
           System.out.println("nem existe kkkkk"); // todo mudar dps
        }

        try {
            userRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            System.out.println("Bugou aq kkkkkk"); // todo mudar dps
        }
    }





}
