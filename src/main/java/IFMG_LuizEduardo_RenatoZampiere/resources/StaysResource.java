package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.services.StaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/stays")
@RestController
public class StaysResource {

    @Autowired
    private StaysService staysService;

    @GetMapping
    public void findAll(){
        staysService.findAll();
        System.out.println("recebendo requisicao find all stays");
    }

    @GetMapping(value = "/{id}")
    public void findById(@PathVariable Long id){
        staysService.findById(id);
    }

    @PostMapping
    public void insert(@RequestBody StaysDTO dto){
        staysService.insert(dto);
    }

    @PutMapping(value = "/{id}")
    public void update(@PathVariable Long id, @RequestBody StaysDTO dto){
        staysService.update(id, dto);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        staysService.delete(id);
    }

}
