package com.accenture.flowershop.be.access.repositories;

import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.State;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    Order findOrderByLoginAndState(String login, State state);
    List<Order> findOrdersByLogin(String login);
    List<Order> findAll();
}
