package com.accenture.flowershop.be.business;

import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.SortedSet;

@Service
public class JMSService {
    @Autowired
    ConnectionFactory connectionFactory;
    @Autowired
    XMLConverter converter;
    @Autowired
    JMSListener listener;

    public boolean toQUEUE(CustomerDTO customerDTO) {
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            String xml = converter.convertFromObjectToXMLString(customerDTO);
            Message message = session.createTextMessage(xml);

            InitialContext ic = new InitialContext();
            Context envContext = (Context) ic.lookup("java:comp/env");
            Destination destination = (Destination) envContext.lookup("jms/outQueue");
            //Destination destination = session.createQueue("");
            MessageProducer producer = session.createProducer(destination);
            connection.start();
            producer.send(message);
            connection.close();
        } catch (JMSException | IOException | NamingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void fromQueue() throws JMSException {
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            InitialContext ic = new InitialContext();
            Context envContext = (Context) ic.lookup("java:comp/env");
            Destination destination = (Destination) envContext.lookup("jms/inQueue");
            MessageConsumer consumer = session.createConsumer(destination);
            consumer.setMessageListener(listener);
            connection.start();
        } catch (JMSException | NamingException e) {
            e.printStackTrace();
            connection.close();
        }
    }
}
