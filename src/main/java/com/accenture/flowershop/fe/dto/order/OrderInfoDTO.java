package com.accenture.flowershop.fe.dto.order;

public class OrderInfoDTO {
    private long id;
    private OrderDTO order;
    private String flower;
    private int floweramount;
    private double cost;
    private double itemCost;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public String getFlower() {
        return flower;
    }

    public void setFlower(String flower) {
        this.flower = flower;
    }

    public int getFloweramount() {
        return floweramount;
    }

    public void setFloweramount(int floweramount) {
        this.floweramount = floweramount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }
}
