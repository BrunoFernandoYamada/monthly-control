package com.bfyamada.monthlyexpensescontrol.utils.security;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import com.bfyamada.monthlyexpensescontrol.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(email);
        }
        return new UserAuth(user.getId(),user.getEmail(),user.getPassword(),user.getRoles());
    }
}
