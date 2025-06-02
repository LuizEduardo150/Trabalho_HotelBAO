package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value="/client")
@RestController
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public void findAll(){
        service.findAll();

    }

    @PostMapping(produces = "application/json")
    public void insert(@RequestBody UserDTO dto){
        service.insert(dto);
    }


    @PutMapping(value = {"/{id}"})
    public void update(@PathVariable Long id, @RequestBody UserDTO dto){
        service.update(id, dto);
    }

    @DeleteMapping(value = {"/{id}"})
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
