package IFMG_LuizEduardo_RenatoZampiere.model.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String price;
    private Integer numberOfBeds;
    private Integer score;

    // imagens ????

    public Room() {}

    public Room(Long id, String name, String price, Integer numberOfBeds, Integer score) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.numberOfBeds = numberOfBeds;
        this.score = score;
    }

    public Integer getScore(){
        return score;
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
}
