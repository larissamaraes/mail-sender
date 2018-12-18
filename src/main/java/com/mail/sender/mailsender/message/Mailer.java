package com.mail.sender.mailsender.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Mailer {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(MailMessage message){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(message.getSender());
        simpleMailMessage.setTo(message.getReceivers().toArray(new String[message.getReceivers().size()]));
        simpleMailMessage.setSubject(message.getSubject());
        simpleMailMessage.setText(message.getBody());

        javaMailSender.send(simpleMailMessage);
    }
}
