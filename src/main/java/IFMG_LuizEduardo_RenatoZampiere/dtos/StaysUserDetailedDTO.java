package IFMG_LuizEduardo_RenatoZampiere.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StaysUserDetailedDTO {

    private Long userId;
    private Long roomId;
    private String roomName;
    private String clientName;
    private String clientPhone;
    private String clientEmail;
    private LocalDate startStay;
    private LocalDate endStay;
    private BigDecimal totalCost;

    public StaysUserDetailedDTO() {}

    public StaysUserDetailedDTO(Long userId, Long roomId, String roomName, String clientName, String clientPhone, String clientEmail, LocalDate startStay, LocalDate endStay, BigDecimal totalCost) {
        this.userId = userId;
        this.roomId = roomId;
        this.roomName = roomName;
        this.clientName = clientName;
        this.clientPhone = clientPhone;
        this.clientEmail = clientEmail;
        this.startStay = startStay;
        this.endStay = endStay;
        this.totalCost = totalCost;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
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
