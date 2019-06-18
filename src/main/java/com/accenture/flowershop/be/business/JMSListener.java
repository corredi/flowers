package com.accenture.flowershop.be.business;

import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.user.DiscountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.io.IOException;

@Service
public class JMSListener implements MessageListener {
    @Autowired
    private XMLConverter xmlConverter;
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        DiscountDTO discountDTO;
        try {
            String xml = textMessage.getText();
            discountDTO = (DiscountDTO) xmlConverter.convertFromStringToObject(xml);
            updateDiscount(discountDTO);
        } catch (JMSException | IOException e) {
            System.out.println("JMS EXCEPTION");
            e.printStackTrace();
        }
    }

    public void updateDiscount(DiscountDTO discountDTO) {
        Customer customer = customerRepository.findByLogin(discountDTO.getLogin());
        customer.setDiscount(discountDTO.getDiscount());
        customerRepository.save(customer);
    }
}