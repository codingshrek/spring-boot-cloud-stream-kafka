package com.micro.consumer.user.service;

import com.micro.api.UserPojo;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService{
    @Override
    public UserPojo createUser(UserPojo pojo) {
        System.out.println("Creating User with username"+pojo.getUsername());
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("User created with username"+pojo.getUsername());
        return pojo;
    }
}
