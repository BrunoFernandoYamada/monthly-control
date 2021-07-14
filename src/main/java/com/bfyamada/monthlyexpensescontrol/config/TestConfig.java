package com.bfyamada.monthlyexpensescontrol.config;

import com.bfyamada.monthlyexpensescontrol.services.DBService;
import com.bfyamada.monthlyexpensescontrol.services.emails.EmailService;
import com.bfyamada.monthlyexpensescontrol.services.emails.MockEmailService;
import com.bfyamada.monthlyexpensescontrol.services.emails.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instantiateDatabase(){
		
		if(!"create".equals(strategy)) {
			return false;
		}
		dbService.instantiateDatabase();
		return true;		
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	

}
