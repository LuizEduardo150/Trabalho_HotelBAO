package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.services.StaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value="/stays")
@RestController
public class StaysResource {

    @Autowired
    private StaysService staysService;

    @GetMapping
    public ResponseEntity<List<StaysDTO>> findAll(){
        List<StaysDTO> stays = staysService.findAll();
        System.out.println("recebendo requisicao find all stays");
        return ResponseEntity.ok().body(stays);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<StaysDTO> findById(@PathVariable Long id){

        StaysDTO stays = staysService.findById(id);
        return ResponseEntity.ok().body(stays);
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
