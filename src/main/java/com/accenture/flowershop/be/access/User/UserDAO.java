package com.accenture.flowershop.be.access.User;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface UserDAO {
    boolean isAdmin(User user);
    boolean isCustomer(User user);
    boolean isBusyByCustomer(String name);
    boolean isBusyByAdmin(String name);
}
