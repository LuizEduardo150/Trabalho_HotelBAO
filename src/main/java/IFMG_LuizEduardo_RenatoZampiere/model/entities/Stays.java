package IFMG_LuizEduardo_RenatoZampiere.model.entities;

import jakarta.persistence.*;

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


    private Long roomId;


    private LocalDate start; //  yyyy-MM-dd
    private LocalDate end; //  yyyy-MM-dd
    private LocalTime entryTime; //  00:00:00
    private LocalTime departureTime; // 00:00:00
    private Float totalCost;


    public Stays(){}

    public Stays(Long id, User userId, Long roomId, LocalDate start, LocalDate end, LocalTime entryTime, LocalTime departureTime, Float totalCost) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
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
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
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

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }
}
