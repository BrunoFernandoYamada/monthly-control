package com.bfyamada.monthlyexpensescontrol.services.emails;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.bfyamada.monthlyexpensescontrol.core.domain.User;

public abstract class AbstractEmailService implements EmailService{

    @Value("${default.sender}")
    private String sender;

    @Autowired
    private JavaMailSender javaMailSender;

   
    @Override
    public void sendNewPasswordEmail(User user, String newPass) {
        SimpleMailMessage sm = prepareNewPasswordEmail(user, newPass);
        sendEmail(sm);
    }

    @Override
    public void sendEmailNewUser(User user) {
        SimpleMailMessage sm = prepareNewUserEmail(user);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(User user, String newPass) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(user.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Solicitação de nova senha");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Nova senha: "+ newPass);
        return sm;
    }

    protected SimpleMailMessage prepareNewUserEmail(User user) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(user.getEmail());
        sm.setFrom(sender);
        sm.setSubject("Spreadsheet new account. Congratulations!!!");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText("Congratulations, yours new account was created");
        return sm;
    }

}