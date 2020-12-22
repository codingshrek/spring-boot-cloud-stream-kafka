package com.micro.consumer.service;


import com.micro.api.UserPojo;
import com.micro.api.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class EmailMessageProcessor {


    protected  EmailService emailService;

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    @StreamListener(target = Sink.INPUT)
    public void process(Event<Integer, UserPojo> event){
        switch (event.getEventType()) {
            case CREATE:
                emailService.sendEmail(event.getData());
                break;
            default:
                String errorMessage = "Incorrect event type: " + event.getEventType() + ", expected a CREATE or DELETE event";
                System.out.println(errorMessage);
        }

    }

}
