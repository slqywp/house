package com.xuhuang.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{
    @Autowired
    private JavaMailSender sender;

    @Value("${spring.mail.username}")
    private String from;

    public void send(String url, String email)
    {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(email);
        msg.setText(url);
        sender.send(msg);
    }
}
