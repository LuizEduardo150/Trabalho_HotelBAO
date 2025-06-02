package IFMG_LuizEduardo_RenatoZampiere.dtos;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

public class StaysDTO {

    private Long userId;
    private Long roomId;
    private LocalDate startStay;
    private LocalDate endStay;
    private LocalTime entryTime;
    private LocalTime departureTime;
    private BigDecimal totalCost;


    public StaysDTO(){}

    public StaysDTO(Long userId, Long roomId, LocalDate start, LocalDate end, LocalTime entryTime, LocalTime departureTime, BigDecimal totalCost) {
        this.userId = userId;
        this.roomId = roomId;
        this.startStay = start;
        this.endStay = end;
        this.entryTime = entryTime;
        this.departureTime = departureTime;
        this.totalCost = totalCost;
    }

    public StaysDTO(Stays stays) {
        userId = stays.getId();
        roomId = stays.getRoomId();
        startStay = stays.getStart();
        endStay = stays.getEnd();
        entryTime = stays.getEntryTime();
        departureTime = stays.getDepartureTime();
        totalCost = stays.getTotalCost();
    }


    public Long getUserId() {
        return userId;
    }

    public void setClientId(Long clientId) {
        this.userId = clientId;
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
}
