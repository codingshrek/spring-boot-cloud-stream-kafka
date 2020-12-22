package com.micro.consumer.service;

import com.micro.api.UserPojo;

public interface EmailService {

    public void sendEmail(UserPojo pojo);
}
