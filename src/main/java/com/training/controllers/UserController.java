package com.training.controllers;

import com.training.repositories.UserRepository;
import com.training.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepo;

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable(value = "id") Long id){
        return userRepo.findOne(id);
    }

    @RequestMapping(value = "/usersearch", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> findUserByEmail(@RequestParam(value = "userName") String userName){
        return userRepo.findByUserName(userName);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@ModelAttribute User user){
        userRepo.save(user);
        return userRepo.findOne(user.getId());
    }

}