package com.accenture.flowershop.be.access.User;

import com.accenture.flowershop.be.entity.user.Customer;
import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface CustomerDAO {
    boolean registerUser(Customer customer);
    Customer getUserInfo(User user);
    boolean updateUser(Customer customer);
}
