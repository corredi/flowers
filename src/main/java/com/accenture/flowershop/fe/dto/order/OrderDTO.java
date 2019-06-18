package com.accenture.flowershop.fe.dto.order;

import com.accenture.flowershop.be.entity.order.State;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private long orderId;
    private String login;
    private double totalCost;
    private State state;
    private LocalDateTime openDate;
    private LocalDateTime closeDate;
    private List<OrderInfoDTO> orderInfo;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDateTime openDate) {
        this.openDate = openDate;
    }

    public LocalDateTime getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(LocalDateTime closeDate) {
        this.closeDate = closeDate;
    }

    public List<OrderInfoDTO> getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(List<OrderInfoDTO> orderInfo) {
        this.orderInfo = orderInfo;
    }
}
