import com.accenture.flowershop.be.access.repositories.AdminRepository;
import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.accenture.flowershop.be.access.repositories.FlowerRepository;
import com.accenture.flowershop.be.business.JMSService;
import com.accenture.flowershop.be.entity.flower.Flower;
import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

import static junit.framework.TestCase.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "../META-INF/Spring.xml")
public class JMSTest {
    @Autowired
    JMSService jmsService;
    @Autowired
    ConnectionFactory connectionFactory;
    @Test
    public void testFindAllFlowers() {
        CustomerDTO customerDTO = new CustomerDTO();
        assertNotNull(jmsService);
        assertTrue(jmsService.toQUEUE(customerDTO));
    }

    @Test
    public void testENV(){
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            InitialContext ic = new InitialContext();
            Context envContext = (Context) ic.lookup("java:comp/env");
            Destination destination = (Destination) envContext.lookup("jms/outQueue");
        }catch (JMSException |NamingException e) {
            e.printStackTrace();
        }

    }
}