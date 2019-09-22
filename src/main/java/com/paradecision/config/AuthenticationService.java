package com.paradecision.config;

import com.paradecision.organizations.users.User;
import com.paradecision.organizations.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@AllArgsConstructor
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
            User userInfo = repository.findUserByUserName(userName);
            GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getRole());
            UserDetails userDetails = (UserDetails)new User(userInfo.getUserName(),
                userInfo.getPassword(), Arrays.asList(authority));
            return userDetails;
    }

}
