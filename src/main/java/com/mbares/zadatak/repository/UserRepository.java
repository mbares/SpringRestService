package com.mbares.zadatak.repository;

import com.mbares.zadatak.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
