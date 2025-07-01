package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.repository.UserRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.DataBaseException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Console;
import java.util.List;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

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
        try {
            userRepository.save(new User(dto));
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Usuário já existe.");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    @Transactional
    public void update(Long id, UserDTO dto){

        try {
            User user = userRepository.getReferenceById(id);
            /*
            user.setUserName(dto.getUserName());
            user.setPassword(dto.getPassword());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setRealName(dto.getRealName());
            user.setAddress(dto.getAddress());
            user.setAddressNumber(dto.getAddressNumber());
            user.setDistrict(dto.getDistrict());
             */
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findByUserName(username);

        User user = opt.orElseThrow(() -> new UsernameNotFoundException("Usuário nâo encontrado."));

        


        return user;
    }


}
