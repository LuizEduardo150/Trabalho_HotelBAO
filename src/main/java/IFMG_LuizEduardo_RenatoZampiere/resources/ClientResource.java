package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.ClientDTO;
import IFMG_LuizEduardo_RenatoZampiere.services.ClientService;
import IFMG_LuizEduardo_RenatoZampiere.utils.InputOutputPers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/client")
@RestController
public class ClientResource {

    @Autowired
    private ClientService service;

    @GetMapping
    public void findAll(){
        System.out.println("olha um findall");
        service.findAll();

    }

    @PostMapping(produces = "application/json")
    public void insert(@RequestBody ClientDTO dto){
        System.out.println("insere, resource"); // todo remover dps
        service.insert(dto);
    }


    @PutMapping(value = {"/{id}"})
    public void update(@PathVariable Long id, @RequestBody ClientDTO dto){
        service.update(id, dto);
    }

    @DeleteMapping(value = {"/{id}"})
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
