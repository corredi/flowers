package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.repositories.AdminRepository;
import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.accenture.flowershop.be.entity.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
public class LoginController {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BagController bagController;
    @Autowired
    private Map map;

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        Admin admin = adminRepository.findByLoginAndPassword(login, pass);
        if (admin != null) {
            System.out.println("logined as admin");
            session.setAttribute("admin",
                    map.entityToAdmin(admin));
            response.sendRedirect("/admin");
            return;
        }
        Customer customer = customerRepository.findByLoginAndPassword(login, pass);
        if (customer != null) {
            System.out.println("logined as customer");
            session.setAttribute("customer",
                    map.entityToCustomer(customer));
            session.setAttribute("sortBy","name");
            response.sendRedirect("/catalog");
            return;
        }
        System.out.println("login failed");

        response.sendRedirect("/login.jsp");
        return;

    }
}