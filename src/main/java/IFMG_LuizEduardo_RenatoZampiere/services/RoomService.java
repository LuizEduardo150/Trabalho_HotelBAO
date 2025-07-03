package IFMG_LuizEduardo_RenatoZampiere.services;

import IFMG_LuizEduardo_RenatoZampiere.dtos.RoomDTO;
import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import IFMG_LuizEduardo_RenatoZampiere.repository.RoomRepository;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.DataBaseException;
import IFMG_LuizEduardo_RenatoZampiere.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;


    public List<RoomDTO> findAll(){
        List<Room> roomList = roomRepository.findAll();
        List<RoomDTO> dto = new ArrayList<>();

        for (Room room : roomList){
            dto.add(new RoomDTO(room));
        }

        return dto;
    }

    public RoomDTO findById(Long id){
        Optional<Room> obj = roomRepository.findById(id);
        Room room = obj.orElseThrow(()-> new ResourceNotFound("Quarto não encontrado: " + id));

        return new RoomDTO(room);
    }

    public void insert(RoomDTO dto){
        try {
            roomRepository.save(new Room(dto));
        }
        catch (DataIntegrityViolationException e) {
            throw new DataBaseException("Falha ao adicionar quarto, verifique os tipos de dado");
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }



}
