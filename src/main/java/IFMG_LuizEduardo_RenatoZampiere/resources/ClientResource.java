package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.utils.InputOutputPers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value="/client")
@RestController
public class ClientResource {

    @GetMapping
    public void findAll(){
        InputOutputPers in = new InputOutputPers();
        in.print("Veja só, comunicando para find all");

    }









}
