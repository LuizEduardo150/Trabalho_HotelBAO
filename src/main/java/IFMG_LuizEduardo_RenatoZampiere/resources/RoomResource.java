package IFMG_LuizEduardo_RenatoZampiere.resources;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;
import org.springframework.boot.autoconfigure.http.client.AbstractHttpRequestFactoryProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RequestMapping(value = "room")
@RestController
public class RoomResource {

    List<Room> rooms = new ArrayList<>();
    boolean added = false;

    @GetMapping
    public List<Room> findAll(){
        // String name, String price, Integer numberOfBeds
        if (! added) {
            rooms.add(new Room(1L, "Familia Prime", "250", 4, 4));
            rooms.add(new Room(2L, "Casal basic", "120", 2, 3));
            rooms.add(new Room(3L, "Solo basic", "85", 1, 2));
            rooms.add(new Room(4L, "Suite Party deluxe", "450", 10, 5));
            rooms.add(new Room(5L, "Suite Party medium", "250", 10, 2));
            rooms.add(new Room(6L, "Dorme com ratos!", "40", 1, 1));
            rooms.add(new Room(7L, "Dorme com ratos mais limpos", "60", 1, 2));
            rooms.add(new Room(8L, "Família classe média", "160", 4, 3));
            rooms.add(new Room(9L, "Família mais comum BR", "160", 4, 2));
            added = true;
        }

        return rooms;
    }








}