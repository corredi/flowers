import com.accenture.flowershop.be.business.XMLConverter;
import com.accenture.flowershop.fe.dto.user.CustomerDTO;
import com.accenture.flowershop.fe.dto.user.DiscountDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.EnumSet;
import java.util.LinkedHashSet;
import java.util.TreeMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="../META-INF/tests.xml")
public class CastorTest {
    private static final String XML_FILE_NAME = "discount.xml";
    private static final String XML_FILE_NAME2 = "customers.xml";
    @Autowired
    XMLConverter converter;
    @Test
    public void mkyongTest() throws IOException {
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setLogin("test");
        discountDTO.setDiscount(30);

        System.out.println("Convert Object to XML!");
        //from object to XML file
        converter.convertFromObjectToXML(discountDTO, XML_FILE_NAME);
        System.out.println("Done \n");
        DiscountDTO discountDTO2 = (DiscountDTO)converter.convertFromXMLToObject(XML_FILE_NAME);
        System.out.println(discountDTO2);
        System.out.println("Done");

/*        System.out.println("Convert XML back to Object!");
        //from XML to object
        Customer customer2 = (Customer)converter.convertFromXMLToObject(XML_FILE_NAME);
        System.out.println(customer2);
        System.out.println("Done");*/
    }

    @Test
    public void myCustomerTest() throws IOException {
        CustomerDTO customer = new CustomerDTO();
        customer.setLogin("test");
        customer.setPassword("test");
        customer.setAddress("donskogo");
        customer.setMoney(new BigDecimal(2000));
        customer.setPhone("123456");
        customer.setDiscount(0);

        System.out.println("Convert Object to XML!");
        //from object to XML file
        converter.convertFromObjectToXML(customer, XML_FILE_NAME2);
        System.out.println("Done \n");

        System.out.println("Convert XML back to Object!");
        //from XML to object
        CustomerDTO customer2 = (CustomerDTO)converter.convertFromXMLToObject(XML_FILE_NAME2);
        System.out.println(customer2);
        System.out.println("Done");

    }
}