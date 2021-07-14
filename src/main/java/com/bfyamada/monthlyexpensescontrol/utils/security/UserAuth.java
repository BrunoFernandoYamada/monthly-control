package com.bfyamada.monthlyexpensescontrol.utils.security;

import com.bfyamada.monthlyexpensescontrol.core.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class UserAuth implements UserDetails {

    private String Id;
    private String email;
    private String password;
    public Collection<? extends GrantedAuthority> authorities;

    public UserAuth(){

    }

    public UserAuth(String id, String email, String password, Set<Role> roles) {
        Id = id;
        this.email = email;
        this.password = password;
        this.authorities = roles.stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
