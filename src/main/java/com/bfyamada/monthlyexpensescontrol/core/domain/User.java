package com.bfyamada.monthlyexpensescontrol.core.domain;

import com.bfyamada.monthlyexpensescontrol.core.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "User_TB")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @NotEmpty(message = "Name is mandatory")
    private String name;

    @NotEmpty(message = "Surname is mandatory")
    private String surname;

    @NotEmpty(message = "Email is mandatory")
    private String email;

    @JsonIgnore
    @NotEmpty(message = "Email is mandatory")
    @Size(min = 6, message = "The min size of password is 6")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "ROLES_TB")
    private Set<Integer> roles = new HashSet<>();


    public User() {
        roles.add(Role.USER.getCod());
    }

    public User(String id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        roles.add(Role.USER.getCod());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles.stream().map(x -> Role.toEnum(x)).collect(Collectors.toSet());
    }

    public void addRole(Role role) {
        roles.add(role.getCod());
    }


}
