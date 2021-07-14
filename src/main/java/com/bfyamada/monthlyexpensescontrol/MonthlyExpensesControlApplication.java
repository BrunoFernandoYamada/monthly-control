package com.bfyamada.monthlyexpensescontrol;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import com.bfyamada.monthlyexpensescontrol.core.enums.Role;
import com.bfyamada.monthlyexpensescontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MonthlyExpensesControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonthlyExpensesControlApplication.class, args);
	}

}
