package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.dtos.UserBasicDataDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserLoginRequestDTO;
import IFMG_LuizEduardo_RenatoZampiere.dtos.UserLoginResponseDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Users", description = "Endpoint for manage Users options")
@RequestMapping(value="/client")
@RestController
public class UserResource {

    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Operation(
            description = "Ask for server to login",
            summary = "login into server",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not Found", responseCode = "401"),
            }
    )
    @PostMapping(value = "/login")
    public ResponseEntity<UserLoginResponseDTO> loginRequest(@RequestBody UserLoginRequestDTO userloguinDto) {

        UserDetails userD = null;
        try {
            userD = service.loadUserByUsername(userloguinDto.getUserName());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        User user = (User) userD;
        if(!passwordEncoder.matches( userloguinDto.getPassword(), user.getPassword() )){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        // else
        UserLoginResponseDTO dto = new UserLoginResponseDTO();
        dto.setUserName(userloguinDto.getUserName());
        dto.setRealName(user.getRealName());
        dto.setUserRole(user.getUserType());

        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            description = "get user by his ID",
            summary = "get user by his ID",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not Found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        UserDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            description = "get users saved on system",
            summary = "get users saved on system",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Internal Error", responseCode = "400"),
            }
    )
    @GetMapping
    public ResponseEntity<Page<UserBasicDataDTO>> findAll(Pageable pageable) {
        Page<UserBasicDataDTO> dtoList = service.findAllResumedPageable(pageable);
        return ResponseEntity.ok().body(dtoList);
    }

    @Operation(
            description = "Insert a new user ",
            summary = "insert a new User",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "Query problems", responseCode = "400"),
            }
    )
    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<Void> insert(@RequestBody UserDTO dto) {
        service.insert(dto);
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "update a  user by his ID",
            summary = "update a  User",
            responses = {
                    @ApiResponse(description = "ok updated", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
                    @ApiResponse(description = "Problems to update", responseCode = "400"),
            }
    )
    @PutMapping(value = {"/{id}"})
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UserDTO dto) {
        service.update(id, dto);
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "delete a  user by his ID",
            summary = "delete a  User",
            responses = {
                    @ApiResponse(description = "ok deleted", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
                    @ApiResponse(description = "Cannot delete a user", responseCode = "400"),
            }
    )
    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "Get the user ID by his user name",
            summary = "get a User by his user name",
            responses = {
                    @ApiResponse(description = "ok", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/gt/{name}")
    public ResponseEntity<UserBasicDataDTO> getUserIdByUserName(@PathVariable String name){
        Long id = service.getUserIdByUserName(name);
        UserBasicDataDTO dto = new UserBasicDataDTO();
        dto.setId(id);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            description = "Get the user by his name",
            summary = "get a User by his name",
            responses = {
                    @ApiResponse(description = "ok ", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/name/{name}")
    public ResponseEntity<UserDTO> findByRealName(@PathVariable String name) {
        UserDTO dto = service.getByRealName(name);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            description = "Get the user by his email",
            summary = "get a User by his email",
            responses = {
                    @ApiResponse(description = "ok ", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/byEmail/{email}")
    public ResponseEntity<UserDTO> findByEmail(@PathVariable String email) {
        UserDTO dto = service.getByEmail(email);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            description = "Get the user by his Username",
            summary = "get a User by his Username",
            responses = {
                    @ApiResponse(description = "ok updated", responseCode = "200"),
                    @ApiResponse(description = "User not found", responseCode = "404"),
            }
    )
    @GetMapping(value = "/byUserName/{userName}")
    public ResponseEntity<UserDTO> findByUserName(@PathVariable String userName) {
        UserDTO dto = service.getByUserName(userName);
        return ResponseEntity.ok().body(dto);
    }

    @Operation(
            description = "Delte all users of the system",
            summary = "Delete all  users",
            responses = {
                    @ApiResponse(description = "ok updated", responseCode = "200"),
                    @ApiResponse(description = "Impossible to delete", responseCode = "400"),
            }
    )
    @DeleteMapping(value = "/dltallsure0-0")
    public ResponseEntity<Void> deleteAllUsers(){
        service.deletAll();
        return ResponseEntity.ok().build();
    }

}
