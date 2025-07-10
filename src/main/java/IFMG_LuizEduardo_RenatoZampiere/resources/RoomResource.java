package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.RoomDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import IFMG_LuizEduardo_RenatoZampiere.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.client.AbstractHttpRequestFactoryProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RequestMapping(value = "room")
@RestController
public class RoomResource {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll(){
        List<RoomDTO> dtoList = roomService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        RoomDTO dto = roomService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody RoomDTO dto){
        roomService.insert(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody RoomDTO dto){
        roomService.updateById(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        roomService.delteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/dltallsure0-0")
    public ResponseEntity<Void> deleteAll(){
        roomService.deleteAll();
        return ResponseEntity.ok().build();
    }


}