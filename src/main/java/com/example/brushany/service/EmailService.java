package com.example.brushany.service;

import com.example.brushany.models.Emails;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Emails emails){

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(emails.getToEmail());
        mailMessage.setSubject(emails.getSubject());
        mailMessage.setText(emails.getMessage());

        mailMessage.setFrom("christofferbrydensholt@gmail.com");


        javaMailSender.send(mailMessage);
    }






}
