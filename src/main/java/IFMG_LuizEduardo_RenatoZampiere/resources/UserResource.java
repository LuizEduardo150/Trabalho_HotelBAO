package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserLoginRequestDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserLoginResponseDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.model.enums.UserType;
import IFMG_LuizEduardo_RenatoZampiere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/client")
@RestController
public class UserResource {

    @Autowired
    private UserService service;

    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResponseDTO> loginRequest(@RequestBody UserLoginRequestDTO userloguinDto){

        UserDetails userD = null;
        try{
            userD = service.loadUserByUsername(userloguinDto.getUserName());
        }catch (UsernameNotFoundException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = (User) userD;

        if (! userloguinDto.getPassword().equals(user.getPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // else
        UserLoginResponseDTO dto = new UserLoginResponseDTO();
        dto.setUserName(userloguinDto.getUserName());
        dto.setRealName(user.getRealName());
        dto.setUserRole(user.getUserType());

        return ResponseEntity.ok().body(dto);
    }


    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> dtoList = service.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<Void> insert(@RequestBody UserDTO dto){
        service.insert(dto);
        return ResponseEntity.ok().build();
    }


    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDTO dto){
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = {"/{id}"})
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
