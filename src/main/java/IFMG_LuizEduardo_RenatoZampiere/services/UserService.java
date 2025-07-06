package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserBasicDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.model.enums.UserType;
import IFMG_LuizEduardo_RenatoZampiere.repository.UserRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.DataBaseException;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.TransactionScoped;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<UserBasicDataDTO> findAllResumedPageable(Pageable pageable){
        Page<UserBasicDataDTO> list = userRepository.getAllPaged(pageable);
        return list.map(UserBasicDataDTO::new);
    }

    @Transactional(readOnly = true)
    public UserDTO getById(Long id){
        Optional<User> obj = userRepository.findById(id);
        User user = obj.orElseThrow(()-> new ResourceNotFound("Usuário não encontrado: " + id));
        user.setPassword("");
        return new UserDTO(user);
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
            user.setUserName(dto.getUsername());
            user.setEmail(dto.getEmail());
            user.setPhone(dto.getPhone());
            user.setRealName(dto.getRealName());
            user.setAddress(dto.getAddress());
            user.setAddressNumber(dto.getAddressNumber());
            user.setDistrict(dto.getDistrict());
            user = userRepository.save(user);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFound("ERRO: Não existe usuário cadastrado com ID: " + id);
        }
        catch (DataIntegrityViolationException e){
            throw new DataBaseException("ERRO, Identificadores devem ser úncio!");
        }
        catch (Exception e){
            System.out.println("default err" + e);
        }
    }

    @Transactional
    public void delete(Long id){
        if(!userRepository.existsById(id)){
           throw new ResourceNotFound("ERRO! Não existe ususário cadastrado com o ID: "+ id);
        }
        try {
            User user = userRepository.getReferenceById(id);
            if (user.getUserType() == UserType.ADMIN){
                throw new DataBaseException("ERRO! Não tem permição para deletar a conta");
            }


            userRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException("Não é possível deletar o usuário");
        }

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepository.findByUserName(username);
        User user = opt.orElseThrow(() -> new UsernameNotFoundException("Usuário nâo encontrado."));
        return user;
    }


    @Transactional(readOnly = true)
    public UserDTO getByUserName(String name){
        Optional<User> opt = userRepository.findByUserName(name);
        User user = opt.orElseThrow(() -> new ResourceNotFound("Usuário não encontrado "+ name));
        user.setPassword("");
        return new UserDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getByRealName(String name){ // todo ver q pode retronar mais de um
        Optional<User> opt = userRepository.getByRealName(name);
        User user = opt.orElseThrow(() -> new ResourceNotFound("Usuário não encontrado" + name));
        user.setPassword("");
        return new UserDTO(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getByEmail(String email){
        Optional<User> opt = userRepository.getByEmail(email);
        User user = opt.orElseThrow(() -> new ResourceNotFound("Email não encontrado: " + email));
        user.setPassword("");
        return new UserDTO(user);

    }

}
