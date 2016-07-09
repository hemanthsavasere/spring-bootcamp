package com.training.repositories;

import java.util.List;

import com.training.models.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Cacheable("users")
    List<User> findByUserName(@Param("userName") String userName);
}