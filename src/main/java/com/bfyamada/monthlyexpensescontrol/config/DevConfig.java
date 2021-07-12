package com.bfyamada.monthlyexpensescontrol.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bfyamada.monthlyexpensescontrol.services.DBService;

@Configuration
public class DevConfig {
	
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
	
	

}
