package com.accenture.flowershop.be.access.repositories;

import com.accenture.flowershop.be.entity.user.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,String> {
    Customer findByLogin(String login);
    Customer findByLoginAndPassword(String login, String password);
}
