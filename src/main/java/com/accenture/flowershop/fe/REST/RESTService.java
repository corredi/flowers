package com.accenture.flowershop.fe.REST;

import com.accenture.flowershop.be.access.repositories.AdminRepository;
import com.accenture.flowershop.be.access.repositories.CustomerRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Component
@Path("/registration")
public class RESTService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AdminRepository adminRepository;

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("/logins")
    public boolean userExists(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode jsonNode = mapper.readTree(json);
            String login = jsonNode.findValue("login").asText();
            System.out.println(login);
            if (customerRepository.findByLogin(login) != null
                    || adminRepository.findByLogin(login) != null) {
                return true;
            }
        } catch (JsonProcessingException e) {

        } catch (IOException e) {

        }
        return false;
    }

}
