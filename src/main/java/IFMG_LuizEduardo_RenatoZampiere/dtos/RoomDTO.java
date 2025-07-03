package IFMG_LuizEduardo_RenatoZampiere.dtos;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.Room;


public class RoomDTO {
    private Long id;
    private String name;
    private String price;
    private Integer numberOfBeds;
    private Integer score;

    public RoomDTO() {}

    public RoomDTO(Long id, String name, String price, Integer numberOfBeds, Integer score) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
        this.score = score;
    }

    public RoomDTO(Room room) {
        this.id = room.getId();
        this.name = room.getName();
        this.price = room.getPrice().toString();
        this.numberOfBeds = room.getNumberOfBeds();
        this.score = room.getScore();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
