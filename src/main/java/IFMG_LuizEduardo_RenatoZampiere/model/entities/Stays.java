package IFMG_LuizEduardo_RenatoZampiere.model.entities;

import IFMG_LuizEduardo_RenatoZampiere.dtos.StaysDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "stays_table")
public class Stays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // todo conferir
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room roomId;

    @Column(nullable = false, unique = false)
    private LocalDate startStay; //  yyyy-MM-dd
    @Column(nullable = false, unique = false)
    private LocalDate endStay; //  yyyy-MM-dd
    private BigDecimal totalCost;

    public Stays(){}

    public Stays(StaysDTO dto){
        User u = new User();
        u.setId(dto.getUserId());
        this.userId = u;
        Room r = new Room();
        r.setId(dto.getRoomId());
        this.roomId = r;
        this.startStay = dto.getStartStay();
        this.endStay = dto.getEndStay();
        this.totalCost = dto.getTotalCost();
    }

    public Stays(Long id, User userId, Long roomId, LocalDate start, LocalDate end, BigDecimal totalCost) {
        this.id = id;
        this.userId = userId;
        Room r = new Room();
        r.setId(roomId);
        this.roomId = r;
        this.startStay = start;
        this.endStay = end;
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Long getRoomId() {
        return roomId.getId();
    }

    public void setRoomId(Long roomId) {
        Room r = new Room();
        r.setId(roomId);
        this.roomId = r;
    }

    public LocalDate getStartStay() {
        return startStay;
    }

    public void setStartStay(LocalDate startStay) {
        this.startStay = startStay;
    }

    public LocalDate getEndStay() {
        return endStay;
    }

    public void setEndStay(LocalDate endStay) {
        this.endStay = endStay;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
