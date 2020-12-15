package com.micro.producer.service;

import com.micro.api.UserPojo;
import com.micro.api.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@EnableBinding(UserServiceImpl.MessageSources.class)
@Service
public class UserServiceImpl implements  UserService{



    MessageSources messageSources;

    @Autowired
    public void setMessageSources(MessageSources messageSources) {
        this.messageSources = messageSources;
    }

    @Override
    public UserPojo createUser(UserPojo pojo) {
        messageSources.outputUser().send(MessageBuilder.withPayload(new Event(Event.Type.CREATE,1,pojo)).build());
        return pojo;
    }

    public interface  MessageSources{
        @Output("output-user")
        public MessageChannel outputUser();
    }





}
