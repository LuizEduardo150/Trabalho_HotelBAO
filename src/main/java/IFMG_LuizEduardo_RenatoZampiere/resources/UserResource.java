package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserBasicDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserLoginRequestDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserLoginResponseDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value="/client")
@RestController
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResponseDTO> loginRequest(@RequestBody UserLoginRequestDTO userloguinDto) {

        UserDetails userD = null;
        try {
            userD = service.loadUserByUsername(userloguinDto.getUserName());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = (User) userD;
        if(!passwordEncoder.matches( userloguinDto.getPassword(), user.getPassword() )){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // else
        UserLoginResponseDTO dto = new UserLoginResponseDTO();
        dto.setUserName(userloguinDto.getUserName());
        dto.setRealName(user.getRealName());
        dto.setUserRole(user.getUserType());

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<UserBasicDataDTO>> findAll(Pageable pageable) {
        Page<UserBasicDataDTO> dtoList = service.findAllResumedPageable(pageable);
        return ResponseEntity.ok().body(dtoList);
    }


    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
        service.insert(dto);
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/gt/{name}")
    public ResponseEntity<UserBasicDataDTO> getUserIdByUserName(@PathVariable String name){
        Long id = service.getUserIdByUserName(name);
        UserBasicDataDTO dto = new UserBasicDataDTO();
        dto.setId(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<UserDTO> findByRealName(@PathVariable String name) {
        UserDTO dto = service.getByRealName(name);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/byEmail/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        UserDTO dto = service.getByEmail(email);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/byUserName/{userName}")
    public ResponseEntity<UserDTO> findByUserName(@PathVariable String userName) {
        UserDTO dto = service.getByUserName(userName);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/dltallsure0-0")
    public ResponseEntity<Void> deleteAllUsers(){
        service.deletAll();
        return ResponseEntity.ok().build();
    }

}
