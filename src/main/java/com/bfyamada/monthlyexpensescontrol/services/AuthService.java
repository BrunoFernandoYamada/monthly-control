package com.bfyamada.monthlyexpensescontrol.services;

import java.util.Random;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import com.bfyamada.monthlyexpensescontrol.utils.security.UserAuth;
import com.bfyamada.monthlyexpensescontrol.repositories.UserRepository;
import com.bfyamada.monthlyexpensescontrol.services.emails.EmailService;
import com.bfyamada.monthlyexpensescontrol.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    private final Random rand = new Random();

    public void sendNewPassword(String email) {

        User user = userRepository.findByEmail(email);

        if(user == null) {
            throw new ObjectNotFoundException("Email não encontrado!");
        }

        String newPass = newPassword();
        user.setPassword(pe.encode(newPass));

        userRepository.save(user);

        emailService.sendNewPasswordEmail(user, newPass);

    }

    private String newPassword() {

        char[] vet = new char[10];
        for(int i = 0; i < 10;i++) {
            vet[i] = randonChar();
        }
        return new String(vet);
    }

    private char randonChar() {
        int opt = rand.nextInt(3);

        if(opt == 0) {//gera um digito
            return (char) (rand.nextInt(10) + 48);
        }else if(opt == 1) {//gera letra maiuscula
            return (char) (rand.nextInt(26) + 65);
        }else{//gera letra minuscula
            return (char) (rand.nextInt(10) + 97);
        }
    }

    public static UserAuth authenticated() {
        try {
            return (UserAuth) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        } catch (Exception e) {
            return null;
        }
    }


}
