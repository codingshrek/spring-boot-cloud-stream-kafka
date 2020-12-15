package com.micro.producer.service;

import com.micro.api.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    protected  UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserPojo createUser(@RequestBody UserPojo pojo){
          return userService.createUser(pojo);
    }
}
