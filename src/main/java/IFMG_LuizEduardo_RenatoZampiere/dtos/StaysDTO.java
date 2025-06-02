package IFMG_LuizEduardo_RenatoZampiere.dtos;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.Stays;

import java.time.LocalDate;
import java.time.LocalTime;

public class StaysDTO {

    private Long userId;
    private Long roomId;
    private LocalDate start;
    private LocalDate end;
    private LocalTime entryTime;
    private LocalTime departureTime;
    private Float totalCost;

    public StaysDTO(){}

    public StaysDTO(Long userId, Long roomId, LocalDate start, LocalDate end, LocalTime entryTime, LocalTime departureTime, Float totalCost) {
        this.userId = userId;
        this.roomId = roomId;
        this.start = start;
        this.end = end;
        this.entryTime = entryTime;
        this.departureTime = departureTime;
        this.totalCost = totalCost;
    }

    public StaysDTO(Stays stays) {
        userId = stays.getId();
        roomId = stays.getRoomId();
        start = stays.getStart();
        end = stays.getEnd();
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
