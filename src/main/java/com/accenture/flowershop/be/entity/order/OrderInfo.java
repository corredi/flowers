package com.accenture.flowershop.be.entity.order;

import com.accenture.flowershop.fe.dto.flower.FlowerDTO;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_INFO")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="info_gen")
    @SequenceGenerator(name="info_gen", sequenceName="ORDER_INFO_SEQ",allocationSize = 1)
    @Column(name = "ID")//,updatable = false, nullable = false)
    private long id;
    /*
    @Column(name = "ORDERID")
    private int orderid;
    */
    @ManyToOne
    @JoinColumn(name = "ORDERID")
    private Order order;
    @Column(name = "FLOWER")
    private String flower;
    @Column(name = "FLOWERAMOUNT")
    private int floweramount;
    @Column(name = "COST")
    private double cost;
    @Column(name = "ITEM_COST")
    private double itemCost;

    public OrderInfo() {
    }

    public OrderInfo(FlowerDTO flower, Order order) {
        this.flower = flower.getName();
        this.floweramount = flower.getStock();
        this.cost = flower.getCost();
        this.setOrder(order);
    }

    public OrderInfo(String flower, int floweramount, double cost) {
        this.flower = flower;
        this.floweramount = floweramount;
        this.cost = cost;
    }

    public OrderInfo(int id, int orderid, String flower, int floweramount, double cost) {
        this.id = id;
        //this.orderid = orderid;
        this.flower = flower;
        this.floweramount = floweramount;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
/*
    public int getOrderId() {
        return orderid;
    }

    public void setOrderId(int orderid) {
        this.orderid = orderid;
    }
*/
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double getItemCost() {
        return itemCost;
    }

    public void setItemCost(double itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
               // ", orderid=" + orderid +
                ", flower='" + flower + '\'' +
                ", floweramount=" + floweramount +
                ", cost=" + cost +
                '}';
    }
}
