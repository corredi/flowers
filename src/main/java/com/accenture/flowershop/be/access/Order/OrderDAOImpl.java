package com.accenture.flowershop.be.access.Order;

//import com.accenture.flowershop.be.business.CreateOrder;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import com.accenture.flowershop.be.entity.order.State;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class OrderDAOImpl implements OrderDAO{
    @PersistenceContext
    private EntityManager em;

    public List<Order> getAllOrders() {
        return em.createQuery("from Order").getResultList();
    }

    @Transactional
    public Order closeOrder(Order order) {
        order.setState(State.CLOSED);
        order.setCloseDate(java.time.LocalDateTime.now());
        order=em.merge(order);
        return order;
    }

    public Order getBag(Customer customer) {
        try {
            return (Order) em.createQuery("From Order where state=:curState and login=:customerLogin")
                    .setParameter("curState", State.OPENED)
                    .setParameter("customerLogin", customer.getLogin())
                    .getResultList().get(0);
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    @Transactional
    public boolean createBag(Customer customer) {
        Order order = new Order(customer);
        em.persist(order);
        return true;
    }

    @Transactional
    public Order updateBag(Order order) {
        order=em.merge(order);
        return order;
    }
/*
    @Transactional
    public boolean makeOrder(List<Flower> flowers, Customer customer) {
        Order order = CreateOrder.newOrder(flowers, customer);
        order.setOpenDate(LocalDateTime.now());
        System.out.println(em.contains(order));
        em.persist(order);
        return true;
    }
*/

    @Transactional
    public boolean makeOrder(Order order) {
        order.setOpenDate(LocalDateTime.now());
        order.setState(State.PAID);
        em.merge(order);
        return true;
    }

    @Transactional
    public boolean payOrder(Order order, Customer customer) {
        double bill = order.getTotalCost();
        if (bill < customer.getMoney().doubleValue()) {
            customer.setMoney(customer.getMoney().subtract(new BigDecimal(bill)));
        } else {
            return false;
        }
        order.setState(State.PAID);
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