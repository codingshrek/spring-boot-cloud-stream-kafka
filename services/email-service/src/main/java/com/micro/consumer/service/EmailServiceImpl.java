package com.micro.consumer.service;

import com.micro.api.UserPojo;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{


    @Override
    public void sendEmail(UserPojo pojo) {
       System.out.println("Sending Email......."+ pojo.getEmail());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Mail Sent to......."+ pojo.getEmail());
    }
}
