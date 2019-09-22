package com.paradecision.config;

import lombok.Data;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Data
public class LoginForm {

    private String userName;
    private String password;

    public UsernamePasswordAuthenticationToken data() {
        return new UsernamePasswordAuthenticationToken(userName, password);

    }
}
