package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.BagController;
import com.accenture.flowershop.be.business.CatalogController;
import com.accenture.flowershop.be.business.OrderController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/form_order")
public class FormAnOrderServler extends HttpServlet {
    @Autowired
    OrderController orderController;
    @Autowired
    CatalogController catalogController;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        orderController.formAnOrder(request.getSession());
        catalogController.findBag(request.getSession());
        response.sendRedirect("/catalog");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletPath();
    }
}