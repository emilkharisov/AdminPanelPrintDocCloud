package ru.knitu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailSender {


    @Qualifier("getJavaMailSender")
    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String username;


    public void send(String toAccount, String subj, String message){

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(username);
            simpleMailMessage.setTo(toAccount);
            simpleMailMessage.setSubject(subj);
            simpleMailMessage.setText(message);

            javaMailSender.send(simpleMailMessage);
    }
}


