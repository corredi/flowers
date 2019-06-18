package com.accenture.flowershop.be.access.Order;
/*
only for test
 */

import com.accenture.flowershop.be.entity.order.OrderInfo;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class OrderInfoDAOImpl implements OrderInfoDAO{
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public boolean updateBag(OrderInfo orderInfo) {
        em.persist(orderInfo);
        return true;
    }
    @Transactional
    public boolean removeItem(OrderInfo orderInfo){
        em.remove(orderInfo);
        return true;
    }

    public List<OrderInfo> getAllOrderInfo() {
        return em.createQuery("from OrderInfo").getResultList();
    }
    @Transactional
    public boolean addOrderInfo(OrderInfo orderInfo) {
        em.persist(orderInfo);
        return true;
    }
}