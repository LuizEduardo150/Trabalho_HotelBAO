package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.RoomDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import IFMG_LuizEduardo_RenatoZampiere.services.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.client.AbstractHttpRequestFactoryProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "Room", description = "Endpoint for manage Rooms")
@RequestMapping(value = "room")
@RestController
public class RoomResource {

    @Autowired
    private RoomService roomService;

    @Operation(
            description = "Get all rooms ",
            summary = "Get all rooms",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
            }
    )
    @GetMapping
    public ResponseEntity<List<RoomDTO>> findAll(){
        List<RoomDTO> dtoList = roomService.findAll();
        return ResponseEntity.ok().body(dtoList);
    }

    @Operation(
        description = "Find a Room by ID",
        summary = "Find room by ID",
        responses = {
                @ApiResponse(description = "ok", responseCode = "200"),
                @ApiResponse(description = "erro", responseCode = "404"),

        }
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<RoomDTO> getRoomById(@PathVariable Long id){
        RoomDTO dto = roomService.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @Operation(
            description = "Insert a Room",
            summary = "Create a new room",
            responses = {
                    @ApiResponse(description = "ok crated", responseCode = "200"),
                    @ApiResponse(description = "erro ao criar", responseCode = "400"),
                    @ApiResponse(description = "Violacao do BD", responseCode = "400"),
            }
    )
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody RoomDTO dto){
        roomService.insert(dto);
        return ResponseEntity.ok().build();
    }


    @Operation(
            description = "update a Room",
            summary = "udate a room",
            responses = {
                    @ApiResponse(description = "ok updated", responseCode = "200"),
                    @ApiResponse(description = "erro ao mudar", responseCode = "404"),
                    @ApiResponse(description = "Violacao do BD", responseCode = "400"),
            }
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody RoomDTO dto){
        roomService.updateById(id, dto);
        return ResponseEntity.ok().build();
    }


    @Operation(
            description = "delete a Room by ID",
            summary = "Delete a room By ID",
            responses = {
                @ApiResponse(description = "ok deleted", responseCode = "200"),
                @ApiResponse(description = "errr on delete", responseCode = "404"),
                @ApiResponse(description = "Violacao do BD", responseCode = "400"),
            }
    )
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        roomService.delteById(id);
        return ResponseEntity.ok().build();
    }


    @Operation(
            description = "delete all data of rooms",
            summary = "Delete all rooms",
            responses = {
                    @ApiResponse(description = "ok deleted", responseCode = "200"),
                    @ApiResponse(description = "Violacao do BD", responseCode = "400"),
            }
    )
    @DeleteMapping(value = "/dltallsure0-0")
    public ResponseEntity<Void> deleteAll(){
        roomService.deleteAll();
        return ResponseEntity.ok().build();
    }


}