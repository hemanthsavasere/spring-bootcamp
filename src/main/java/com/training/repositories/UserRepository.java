package com.training.repositories;

import java.util.List;

import com.training.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByUserName(@Param("userName") String userName);
}