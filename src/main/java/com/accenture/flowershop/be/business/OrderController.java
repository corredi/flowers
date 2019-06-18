package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.accenture.flowershop.be.access.repositories.FlowerRepository;
import com.accenture.flowershop.be.access.repositories.OrderRepository;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import com.accenture.flowershop.be.entity.order.State;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Controller
public class OrderController {
    //@Autowired
    //OrderDAO orderDAO;
    //@Autowired
    //CustomerDAO customerDAO;
    //@Autowired
    //FlowerDAO flowerDAO;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    FlowerRepository flowerRepository;
    @Autowired
    Map map;

    public boolean formAnOrder(HttpSession session) {
        Order order = map.orderToEntity((OrderDTO) session.getAttribute("bag"));
        Customer customer = map.customerToEntity((CustomerDTO) session.getAttribute("customer"));
        if (order.getOrderInfo().size() > 0) {
            if (customer.getMoney().compareTo
                    (new BigDecimal(order.getTotalCost())) >= 0) {
                checkout(order, customer);
                customer=customerRepository.findByLogin(customer.getLogin());
                session.setAttribute("customer",
                        map.entityToCustomer(customer));
                return true;
            }
        }
        return false;
    }

    @Transactional(rollbackOn = Exception.class)
    public boolean checkout(Order order, Customer customer) {
        for (OrderInfo item : order.getOrderInfo()) {
            Flower tempFlower = flowerRepository.findByName(item.getFlower());
            if (tempFlower.getStock() < item.getFloweramount()) {
                return false;
            }
        }
        for (OrderInfo item : order.getOrderInfo()) {
            Flower tempFlower = flowerRepository.findByName(item.getFlower());
            tempFlower.setStock(tempFlower.getStock() - item.getFloweramount());
            flowerRepository.save(tempFlower);
            //flowerDAO.updateFlowerStock(tempFlower);
        }
        order.setState(State.PAID);
        order.setOpenDate(LocalDateTime.now());
        orderRepository.save(order);
        //orderDAO.makeOrder(order);
        customer.setMoney(
                customer.getMoney().subtract
                        (new BigDecimal(order.getTotalCost())));
        customerRepository.save(customer);
        return true;
    }
}
