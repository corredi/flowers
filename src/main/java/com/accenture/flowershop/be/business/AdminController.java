package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.repositories.OrderRepository;
import com.accenture.flowershop.be.entity.order.Order;
import com.accenture.flowershop.be.entity.order.State;
import com.accenture.flowershop.fe.dto.order.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Service
public class AdminController {
    //@Autowired
    //OrderDAO orderDAO;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    Map map;


    public void adminPage(HttpServletRequest request, HttpServletResponse response)throws IOException {
        //Iterable<Order> orders = orderRepository.findAll();
        List<Order> orders=orderRepository.findAll();
        request.getSession().setAttribute("orders",
                map.listToOrderDTO(orders));
        response.sendRedirect("/admin.jsp");
    }

    public void closeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession();
        List<Order> orders=map.listToOrderEntity((List<OrderDTO>)session.getAttribute("orders"));
        //Iterable<Order> orders=(Iterable<Order>)session.getAttribute("orders");
        for(Order order:orders){
            if(request.getParameter(""+order.getOrderId())!=null)
            {
                order.setState(State.CLOSED);
                orderRepository.save(order);
                response.sendRedirect("/admin");
                return;
                //orderDAO.closeOrder(order);
            }
        }
        response.sendRedirect("/admin");
    }
}
