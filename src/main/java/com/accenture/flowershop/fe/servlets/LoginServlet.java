package com.accenture.flowershop.fe.servlets;

import com.accenture.flowershop.be.business.JMSService;
import com.accenture.flowershop.be.business.LoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.jms.JMSException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {

    @Autowired
    private LoginController loginController;
    @Autowired
    JMSService jmsService;
    public void init(ServletConfig config) throws ServletException{
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
        try{
            jmsService.fromQueue();
        }catch(JMSException e){
            System.out.println("JMS EXCEPTION");
            e.getErrorCode();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        loginController.login(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //request.getServletPath();
        response.sendRedirect("/login.jsp");
    }
}
