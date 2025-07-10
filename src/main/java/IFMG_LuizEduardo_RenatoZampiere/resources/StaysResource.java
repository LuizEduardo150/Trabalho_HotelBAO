package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDetailedWithoutUserDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysUserDetailedDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.repository.UserRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.StaysService;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "Stays", description = "Endpoint for manage Hotel Stays")
@RequestMapping(value="/stays")
@RestController
public class StaysResource {

    @Autowired
    private StaysService staysService;

    @Autowired
    private UserRepository userRepository;

    @Operation(
            description = "Find all Stays",
            summary = "Find all stays saved",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "errro BD", responseCode = "404"),
            }
    )
    @GetMapping
    public ResponseEntity<List<StaysDTO>> findAll(){
        List<StaysDTO> stays = staysService.findAll();
        return ResponseEntity.ok().body(stays);
    }

    @Operation(
            description = "Find all Stays, but with more details",
            summary = "Find all Stays, but with more details",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "errro BD", responseCode = "404"),
            }
    )
    @GetMapping(value = "/det")
    public ResponseEntity<List<StaysUserDetailedDTO>> findAllDetailed(){
        List<StaysUserDetailedDTO> stays = staysService.findAllDetailed();
        return ResponseEntity.ok().body(stays);
    }


    @Operation(
            description = "Find stay, by id",
            summary = "Find stay, by id",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Stay not found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<StaysDTO> findById(@PathVariable Long id){

        StaysDTO stays = staysService.findById(id);
        return ResponseEntity.ok().body(stays);
    }

    @Operation(
        description = "Find all stays, of a same Room ID",
        summary = "Find all stays, of a same Room ID",
        responses = {
                @ApiResponse(description = "ok", responseCode = "200"),
                @ApiResponse(description = "Room Id not found", responseCode = "404"),
        }
    )
    @GetMapping(value = "/Rstays/{id}")
    public ResponseEntity<List<StaysDTO>> getStaysByRoomId(@PathVariable Long id){
        List<StaysDTO> list =  staysService.getStaysOfRoomById(id);
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            description = "Find all stays detailed of a user Room ID, but without many information about user",
            summary = "Find all stays detailed of a user Room ID, but without many information about user",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User ID not found", responseCode = "404"),
            }
    )
    @GetMapping(value="/staysDWTOUserD/{user_id}")
    public ResponseEntity<List<StaysDetailedWithoutUserDataDTO>> getStaysDetailedWithoutUserData(@PathVariable Long user_id){
        List<StaysDetailedWithoutUserDataDTO> list = staysService.getStaysDetailedWithoutUserData(user_id);
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            description = "Insert stay",
            summary = "Insert stay",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Illegal insert", responseCode = "400"),
            }
    )
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody StaysDTO dto){

        staysService.insert(dto);

        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "Update a stay, but only start and end date",
            summary = "Update a stay, but only start and end date",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Stay not Found", responseCode = "404"),
                    @ApiResponse(description = "Illegal update", responseCode = "400"),
            }
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody StaysDTO dto){

        staysService.update(id, dto);

        return ResponseEntity.ok().build();
    }


    @Operation(
            description = "Delete a stay",
            summary = "Delete a stay",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Stay not Found", responseCode = "404"),
                    @ApiResponse(description = "Illegal delete", responseCode = "400"),
            }
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        staysService.delete(id);

        return ResponseEntity.ok().build();
    }


    @Operation(
        description = "get all stays, Of a User, by his ID, with max details",
        summary = "get all stays, Of a User, by his ID",
        responses = {
                @ApiResponse(description = "ok", responseCode = "200"),
                @ApiResponse(description = "User not Found", responseCode = "404"),
        }
    )
    @GetMapping(value = "/Ustays/{id}")
    public ResponseEntity<List<StaysUserDetailedDTO>> getStaysByUserId(@PathVariable Long id){
        List<StaysUserDetailedDTO> list =  staysService.getStaysUserId(id);
        return ResponseEntity.ok().body(list);
    }

    @Operation(
            description = "get all stays, Of a User, by his email, with max details",
            summary = "get all stays, Of a User, by his email",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not Found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/UstaysBMail/{email}")
    public ResponseEntity<List<StaysUserDetailedDTO>> getStaysByUserEmail(@PathVariable String email){

        Optional<User> opt = userRepository.getByEmail(email);

        User user = opt.orElseThrow(() -> new ResourceNotFound("Nao há usuarios cadastrados nesse email"));
        List<StaysUserDetailedDTO> list =  staysService.getStaysUserId(user.getId());

        return ResponseEntity.ok().body(list);
    }


    @Operation(
            description = "get all stays, Of a User, by his user name, with room details only",
            summary = "get all stays, Of a User, by his user name",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not Found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/UstaysBUname/{userName}")
    public ResponseEntity<List<StaysDetailedWithoutUserDataDTO>> getStaysByUserName(@PathVariable String userName){

        List<StaysDetailedWithoutUserDataDTO> dto = staysService.getStaysByUserName(userName);
        return ResponseEntity.ok().body(dto);
    }


    @Operation(
            description = "delete all stays",
            summary = "delte all stays",
            responses = {
                    @ApiResponse(description = "ok deleted", responseCode = "200"),
                    @ApiResponse(description = "Impossible to delete", responseCode = "400"),
            }
    )
    @DeleteMapping(value = "/dltallsure0-0")
    public ResponseEntity<Void> deleteAll(){
        staysService.deleAllStays();
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "get a stay, with the most expansive total cost Of a User, by his userName",
            summary = "get a stay, Of a User, by his userName",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not Found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/usrMExStay/{userName}")
    public ResponseEntity<StaysDetailedWithoutUserDataDTO> getUserMostExpensiveStay(@PathVariable String userName){
        StaysDetailedWithoutUserDataDTO retdto = staysService.getUserMostExpensiveStay(userName);
        return ResponseEntity.ok().body(retdto);
    }

    @Operation(
            description = "get a stay, with the less expansive total cost Of a User, by his userName",
            summary = "get a stay, Of a User, by his userName",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not Found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/usrLExStay/{userName}")
    public ResponseEntity<StaysDetailedWithoutUserDataDTO> getUserLessExpensiveStay(@PathVariable String userName){
        StaysDetailedWithoutUserDataDTO retdto = staysService.getUserLessExpensiveStay(userName);
        return ResponseEntity.ok().body(retdto);
    }



}
