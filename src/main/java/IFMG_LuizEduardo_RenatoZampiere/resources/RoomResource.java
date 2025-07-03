package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.RoomDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import IFMG_LuizEduardo_RenatoZampiere.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.client.AbstractHttpRequestFactoryProperties;
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
    public List<RoomDTO> findAll(){
        return roomService.findAll();
    }

    @GetMapping(value = "/id")
    public RoomDTO getRoomById(@PathVariable Long id){
        roomService.findById(id);
        return null;
    }

    @PostMapping
    public void insert(@RequestBody RoomDTO dto){
        roomService.insert(dto);
    }

    @PutMapping
    public void update(@PathVariable Long id, @RequestBody RoomDTO dto){

    }

    @DeleteMapping(value = "/id")
    public void delete(){

    }















}