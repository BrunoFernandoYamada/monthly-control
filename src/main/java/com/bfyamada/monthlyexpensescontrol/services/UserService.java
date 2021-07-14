package com.bfyamada.monthlyexpensescontrol.services;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import com.bfyamada.monthlyexpensescontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UserRepository repo;

    public User save(User user){
        user.setPassword(pe.encode(user.getPassword()));
        User newUser = repo.save(user);

        return newUser;
    }

}
