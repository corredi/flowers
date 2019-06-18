package com.accenture.flowershop.be.access.Order;

import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDAO {
    List<Order> getAllOrders();
    Order closeOrder(Order order);
    Order getBag(Customer customer);
    boolean createBag(Customer customer);
    Order updateBag(Order order);
    boolean makeOrder(Order order);
    boolean payOrder(Order order, Customer customer);
    List<Order> findUserOrders(User user);
    boolean deleteOrder(Order order);
}
