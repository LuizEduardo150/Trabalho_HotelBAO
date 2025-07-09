package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDetailedWithoutUserDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysUserDetailedDTO;
import IFMG_LuizEduardo_RenatoZampiere.services.StaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value="/stays")
@RestController
public class StaysResource {

    @Autowired
    private StaysService staysService;

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




}
