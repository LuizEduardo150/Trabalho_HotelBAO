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
    private BigDecimal totalCost;


    public StaysDTO(){}

    public StaysDTO(Long userId, Long roomId, LocalDate start, LocalDate end, LocalTime entryTime, LocalTime departureTime, BigDecimal totalCost) {
        this.userId = userId;
        this.roomId = roomId;
        this.startStay = start;
        this.endStay = end;
        this.totalCost = totalCost;
    }

    public StaysDTO(Stays stays) {
        userId = stays.getId();
        roomId = stays.getRoomId();
        startStay = stays.getStartStay();
        endStay = stays.getEndStay();
        totalCost = stays.getTotalCost();
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
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
