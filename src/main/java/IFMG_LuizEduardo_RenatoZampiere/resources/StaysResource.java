package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDetailedWithoutUserDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysUserDetailedDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.repository.UserRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.StaysService;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value="/stays")
@RestController
public class StaysResource {

    @Autowired
    private StaysService staysService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<StaysDTO>> findAll(){
        List<StaysDTO> stays = staysService.findAll();
        return ResponseEntity.ok().body(stays);
    }

    @GetMapping(value = "/det")
    public ResponseEntity<List<StaysUserDetailedDTO>> findAllDetailed(){
        List<StaysUserDetailedDTO> stays = staysService.findAllDetailed();
        return ResponseEntity.ok().body(stays);
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<StaysDTO> findById(@PathVariable Long id){

        StaysDTO stays = staysService.findById(id);
        return ResponseEntity.ok().body(stays);
    }

    @GetMapping(value = "/Rstays/{id}")
    public ResponseEntity<List<StaysDTO>> getStaysByRoomId(@PathVariable Long id){
        List<StaysDTO> list =  staysService.getStaysOfRoomById(id);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value="/staysDWTOUserD/{user_id}")
    public ResponseEntity<List<StaysDetailedWithoutUserDataDTO>> getStaysDetailedWithoutUserData(@PathVariable Long user_id){
        List<StaysDetailedWithoutUserDataDTO> list = staysService.getStaysDetailedWithoutUserData(user_id);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody StaysDTO dto){

        staysService.insert(dto);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody StaysDTO dto){

        staysService.update(id, dto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        staysService.delete(id);

        return ResponseEntity.ok().build();
    }


    @GetMapping(value = "/Ustays/{id}")
    public ResponseEntity<List<StaysUserDetailedDTO>> getStaysByUserId(@PathVariable Long id){
        List<StaysUserDetailedDTO> list =  staysService.getStaysUserId(id);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/UstaysBMail/{email}")
    public ResponseEntity<List<StaysUserDetailedDTO>> getStaysByUserEmail(@PathVariable String email){

        Optional<User> opt = userRepository.getByEmail(email);

        User user = opt.orElseThrow(() -> new ResourceNotFound("Nao há usuarios cadastrados nesse email"));
        List<StaysUserDetailedDTO> list =  staysService.getStaysUserId(user.getId());

        return ResponseEntity.ok().body(list);
    }

    @DeleteMapping(value = "/dltallsure0-0")
    public ResponseEntity<Void> deleteAll(){
        staysService.deleAllStays();
        return ResponseEntity.ok().build();
    }



}
