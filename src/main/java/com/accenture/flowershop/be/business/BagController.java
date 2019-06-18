package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.repositories.OrderRepository;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.OrderInfo;
import com.accenture.flowershop.be.entity.order.State;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class BagController {
    //@Autowired
    //OrderDAO orderDAO;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    Map map;

    public OrderInfo calculateSingle(OrderInfo orderInfo, Customer customer) {
        orderInfo.setItemCost(
                ((100.0 - (double) customer.getDiscount()) / 100.0) *
                        (orderInfo.getCost() * (double) orderInfo.getFloweramount())
        );
        return orderInfo;

    }

    public Order calculateTotal(Order order, Customer customer) {
        double temp = 0;
        for (OrderInfo item : order.getOrderInfo()) {
            if (item == null) {

            }
            item = calculateSingle(item, customer);
            temp += item.getItemCost();
        }
        order.setTotalCost(temp);
        return order;
    }

    public void updateBag(HttpSession session, Order bag){
        orderRepository.save(bag);
        bag=orderRepository.findOrderByLoginAndState(bag.getLogin(),State.OPENED);
        session.setAttribute("bag",
                map.entityToOrder(bag));
    }

    public void updateItemInBag(HttpSession session, OrderInfo orderInfo) throws IOException {
        Order bag = map.orderToEntity((OrderDTO) session.getAttribute("bag"));
        Customer customer = map.customerToEntity((CustomerDTO) session.getAttribute("customer"));
        List<OrderInfo> bagItems = bag.getOrderInfo();
        for (OrderInfo item : bagItems) {
            if (item.getFlower().equals(orderInfo.getFlower())) {
                item.setFloweramount(
                        orderInfo.getFloweramount()
                );
                bag = calculateTotal(bag, customer);
                updateBag(session,bag);
                //bag = orderDAO.updateBag(bag);
                return;
            }
        }
    }

    public void controll(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Order bag = map.orderToEntity((OrderDTO) session.getAttribute("bag"));
        Customer customer = map.customerToEntity((CustomerDTO) session.getAttribute("customer"));
        for (OrderInfo orderInfo : bag.getOrderInfo()) {
            if (request.getParameter("order" + orderInfo.getFlower()) != null) {
                {
                    try {
                        int amount = Integer.parseInt(
                                request.getParameter("order" + orderInfo.getFlower())

                        );
                        System.out.println("HERE");
                        System.out.println(amount);
                        if (amount > 0) {
                            orderInfo.setFloweramount(amount);
                            updateItemInBag(session, orderInfo);
                            response.sendRedirect("bag.jsp");
                            return;
                        } else if (amount == 0) {
                            List<OrderInfo> temp = bag.getOrderInfo();
                            temp.remove(orderInfo);
                            bag.setOrderInfo(temp);
                            orderInfo.setOrder(null);
                            bag = calculateTotal(bag, customer);
                            updateBag(session,bag);
                            //bag = orderDAO.updateBag(bag);
                            response.sendRedirect("bag.jsp");
                            return;
                        }
                    } catch (NumberFormatException e) {
                        response.sendRedirect("bag.jsp");
                        return;
                    }
                }
            }
        }
        bag=orderRepository.findOrderByLoginAndState(customer.getLogin(),State.OPENED);
        session.setAttribute("bag",
                map.entityToOrder(bag));
        response.sendRedirect("bag.jsp");
    }
}
