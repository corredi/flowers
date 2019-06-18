package com.accenture.flowershop.be.business;


import com.accenture.flowershop.be.access.repositories.AdminRepository;
import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

@Component
public class RegistrationController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    XMLConverter converter;
    @Autowired
    ConnectionFactory connectionFactory;
    @Autowired
    JMSService jmsService;
    @Autowired
    Map map;

    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Customer customer = new Customer(
                request.getParameter("login"),
                request.getParameter("password"),
                request.getParameter("address"),
                request.getParameter("phone")
        );
        if (adminRepository.findByLogin(customer.getLogin()) != null ||
                customerRepository.findByLogin(customer.getLogin()) != null) {
            response.sendRedirect("/register.jsp");
        } else {
            customer.setMoney(new BigDecimal(2000));
            customer.setDiscount(0);
            if (customer.getLogin() != null) {
                customerRepository.save(customer);
                CustomerDTO customerDTO = map.entityToCustomer(customer);
                /*
                XML
                 */
                converter.convertFromObjectToXML(customerDTO, "new customer");
                /*
                XML to activeMQ
                 */
                jmsService.toQUEUE(customerDTO);

            }
            response.sendRedirect("/login.jsp");
        }
    }
}
