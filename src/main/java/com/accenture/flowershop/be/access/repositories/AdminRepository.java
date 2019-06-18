package com.accenture.flowershop.be.access.repositories;

import com.accenture.flowershop.be.entity.user.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin,String> {
    public Admin findByLoginAndPassword(String login, String password);
    public Admin findByLogin(String login);
}
