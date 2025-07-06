package IFMG_LuizEduardo_RenatoZampiere.model.entities;

import IFMG_LuizEduardo_RenatoZampiere.dtos.RoomDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "rooms_table")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(precision = 15, scale = 2, nullable = false, unique = false)
    private BigDecimal price;

    @Column(nullable = false, unique = false)
    private Integer numberOfBeds;

    @Column(nullable = false, unique = false)
    private Integer score;

    // imagens ????

    public Room() {}

    public Room(String name, String price, Integer numberOfBeds, Integer score) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.numberOfBeds = numberOfBeds;
        this.score = score;
    }

    public Room(RoomDTO dto){
        this.name = dto.getName();
        this.price = new BigDecimal(dto.getPrice());
        this.numberOfBeds = dto.getNumberOfBeds();
        this.score = dto.getScore();
    }

    public void setScore(Integer score) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(Integer numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }
}
