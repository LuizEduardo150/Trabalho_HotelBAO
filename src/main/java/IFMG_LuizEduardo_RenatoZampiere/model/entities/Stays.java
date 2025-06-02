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

    private Long roomId; // todo mudar dps para chave estranjeira

    private LocalDate startStay; //  yyyy-MM-dd
    private LocalDate endStay; //  yyyy-MM-dd
    private LocalTime entryTime; //  00:00:00
    private LocalTime departureTime; // 00:00:00
    private BigDecimal totalCost;

    public Stays(){}

    public Stays(StaysDTO dto){
        User u = new User();
        u.setId(dto.getUserId());
        this.userId = u;
        this.roomId = dto.getRoomId();
        this.startStay = dto.getStart();
        this.endStay = dto.getEnd();
        this.entryTime = dto.getEntryTime();
        this.departureTime = dto.getDepartureTime();
        this.totalCost = dto.getTotalCost();
    }

    public Stays(Long id, User userId, Long roomId, LocalDate start, LocalDate end, LocalTime entryTime, LocalTime departureTime, BigDecimal totalCost) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.startStay = start;
        this.endStay = end;
        this.entryTime = entryTime;
        this.departureTime = departureTime;
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
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getStart() {
        return startStay;
    }

    public void setStart(LocalDate start) {
        this.startStay = start;
    }

    public LocalDate getEnd() {
        return endStay;
    }

    public void setEnd(LocalDate end) {
        this.endStay = end;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "Stays{" +
                "id=" + id +
                ", userId=" + userId +
                ", roomId=" + roomId +
                ", startStays=" + startStay +
                ", endStays=" + endStay +
                ", entryTime=" + entryTime +
                ", departureTime=" + departureTime +
                ", totalCost=" + totalCost +
                '}';
    }
}
