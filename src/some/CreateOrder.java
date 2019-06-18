package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.Customer;

import java.util.List;

public class CreateOrder {

    public static Order newOrder(List<Flower> flowers,Customer customer) {
        Order order=new Order(flowers,customer);
        order.setTotalCost(calculateCost(flowers,customer));
        return order;
    }

    public static double calculateCost(List<Flower> flowers, Customer customer){
        double cost=0;
        for(Flower flower:flowers){
            cost+=flower.getCost()*flower.getStock()*((100-customer.getDiscount())/100);
        }
        return cost;
    }
}
