package com.accenture.flowershop.be.access.repositories;

import com.accenture.flowershop.be.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserRepository extends CrudRepository<User,String> {
}
