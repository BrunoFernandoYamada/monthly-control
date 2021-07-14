package com.bfyamada.monthlyexpensescontrol.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.bfyamada.monthlyexpensescontrol.core.domain.User;
import com.bfyamada.monthlyexpensescontrol.utils.security.UserAuth;
import com.bfyamada.monthlyexpensescontrol.core.dto.EmailDTO;
import com.bfyamada.monthlyexpensescontrol.services.AuthService;
import com.bfyamada.monthlyexpensescontrol.services.UserService;
import com.bfyamada.monthlyexpensescontrol.utils.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/auth")
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/register")
    public ResponseEntity<Void> register(User user){
        userService.save(user);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value="/refresh_token", method=RequestMethod.POST)
    public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
        UserAuth user = authService.authenticated();
        String token = jwtUtil.generationToken(user.getUsername());
        response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/forgot", method=RequestMethod.POST)
    public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDto) {
        authService.sendNewPassword(objDto.getEmail());
        return ResponseEntity.noContent().build();
    }


}