package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.LoginController;
import com.accenture.flowershop.be.business.RegistrationController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns ="/register")
public class RegisterServlet extends HttpServlet{

    @Autowired
    RegistrationController registrationController;

    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registrationController.register(request,response);
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getServletPath();
        response.sendRedirect("/register.jsp");
    }
}
