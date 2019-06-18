package com.accenture.flowershop.be.entity.flower;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "FLOWER")
public class Flower implements Serializable {
    @Id
    @Column(name = "NAME")
    private String name;
    @Column(name = "cost")
    private double cost;
    @Column(name = "stock")
    private int stock;
    public Flower() {
    }

    public Flower(String name, double cost, int stock) {
        this.name = name;
        this.cost = cost;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", stock=" + stock +
                '}';
    }
}
