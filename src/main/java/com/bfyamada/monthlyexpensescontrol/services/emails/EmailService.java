package com.bfyamada.monthlyexpensescontrol.services.emails;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;

@Service
public interface EmailService {
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(User user,String newPass);

	void sendEmailNewUser(User user);


}
