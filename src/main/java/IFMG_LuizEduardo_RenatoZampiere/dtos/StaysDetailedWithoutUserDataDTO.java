package IFMG_LuizEduardo_RenatoZampiere.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StaysDetailedWithoutUserDataDTO {

    private String roomName;
    private String score;
    private BigDecimal roomCost;
    private BigDecimal totalStayCost;
    private LocalDate startStay;
    private LocalDate endStay;

    public StaysDetailedWithoutUserDataDTO(){}

    public StaysDetailedWithoutUserDataDTO(String roomName, String score, BigDecimal roomCost, BigDecimal totalStayCost, LocalDate startStay, LocalDate endStay) {
        this.roomName = roomName;
        this.score = score;
        this.roomCost = roomCost;
        this.totalStayCost = totalStayCost;
        this.startStay = startStay;
        this.endStay = endStay;
    }

    public BigDecimal getTotalStayCost() {
        return totalStayCost;
    }

    public void setTotalStayCost(BigDecimal totalStayCost) {
        this.totalStayCost = totalStayCost;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public BigDecimal getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(BigDecimal roomCost) {
        this.roomCost = roomCost;
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
}
