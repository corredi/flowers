package com.accenture.flowershop.be.access.Order;

import com.accenture.flowershop.be.access.Flower.FlowerDAOService;
import com.accenture.flowershop.be.business.CreateOrder;
import com.accenture.flowershop.be.business.HibernateUtil;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Transient;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderDAO {
    private static final String OPENED = "opened";
    private static final String PAID = "paid";
    private static final String CLOSED = "closed";

    @PersistenceContext
    private EntityManager em;

    public List<Order> getAllOrders() {
        return em.createQuery("from Order").getResultList();
    }
    @Transactional
    public boolean closeOrder(Order order) {
        order.setState("closed");
        order.setCloseDate(java.time.LocalDateTime.now());
        em.merge(order);
        return true;
    }
    @Transactional
    @Transient
    public boolean makeOrder(List<Flower> flowers, Customer customer) {
        Order order = CreateOrder.newOrder(flowers, customer);
        System.out.println(order);
        order.setOpenDate(LocalDateTime.now());
        for(OrderInfo orderInfo:order.getOrderInfo()){

        }
        em.persist(order.getOrderInfo());
        em.persist(order);
        return true;
    }
    @Transactional

    public boolean payOrder(Order order, Customer customer) {
        double bill = order.getTotalcost();
        if (bill < customer.getMoney().doubleValue()) {
            customer.setMoney(customer.getMoney().subtract(new BigDecimal(bill)));
        } else {
            return false;
        }
        order.setState("paid");
        em.merge(order);
        return true;
    }

    public List<Order> findUserOrders(User user) {
        return em.createQuery("from Order where login=:username").
                setParameter("username", user.getLogin()).getResultList();
    }
    @Transactional
    public boolean deleteOrder(Order order) {
        em.remove(order);
        return true;
    }
}