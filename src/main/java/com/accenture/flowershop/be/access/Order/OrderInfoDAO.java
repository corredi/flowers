package com.accenture.flowershop.be.access.Order;

import com.accenture.flowershop.be.entity.order.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderInfoDAO {
    List<OrderInfo> getAllOrderInfo();
    boolean updateBag(OrderInfo orderInfo);
    boolean addOrderInfo(OrderInfo orderInfo);
    boolean removeItem(OrderInfo orderInfo);
}
