package com.accenture.flowershop.be.access.Order;

import com.accenture.flowershop.be.access.Flower.FlowerDAO;
import com.accenture.flowershop.be.business.CreateOrder;
import com.accenture.flowershop.be.business.HibernateUtil;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderDAOService {
    @Autowired
    private OrderDAO orderDAO;


    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    public boolean closeOrder(Order order) {
        return orderDAO.closeOrder(order);
    }

    public boolean makeOrder(List<Flower> flowers, Customer customer) {
        return orderDAO.makeOrder(flowers,customer);
    }
    public boolean createOrder(List<Flower> flowers, Customer customer) {
        return orderDAO.createOrder(flowers,customer);
    }
    public boolean payOrder(Order order, Customer customer) {
        return orderDAO.payOrder(order, customer);
    }

    public List<Order> findUserOrders(User user) {
        return orderDAO.findUserOrders(user);
    }

    public boolean deleteOrder(Order order) {
        return orderDAO.deleteOrder(order);
    }

}
