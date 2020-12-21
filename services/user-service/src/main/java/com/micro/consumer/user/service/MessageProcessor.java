package com.micro.consumer.user.service;

import com.micro.api.UserPojo;
import com.micro.api.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MessageProcessor {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @StreamListener(Sink.INPUT)
    public void processMessage(Event<Integer, UserPojo> event){


        switch (event.getEventType()){
            case CREATE:
                userService.createUser(event.getData());
                break;
            default:
                String errorMessage = "Incorrect event type: " + event.getEventType() + ", expected a CREATE or DELETE event";
                System.out.println(errorMessage);
        }

    }

}
