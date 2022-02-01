package com.laboratorio.oauth.services;

import com.laboratorio.oauth.clients.UserFeignClient;
import com.laboratorio.oauth.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class UserService implements IUserService, UserDetailsService {


    private UserFeignClient client;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = client.findByUsername(username);

        if(user == null) {
            log.error("The user " + username + " doesn't exist");
            throw new UsernameNotFoundException("The user " + username + " doesn't exist");
        }

        List<GrantedAuthority> authorities = user.getRoles()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .peek(authority -> log.info("Role: "+authority.getAuthority()))
                .collect(Collectors.toList());

        log.info("Auth user: {}", username);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.isEnabled(),
                true,
                true,
                true,
                authorities);
    }

    @Override
    public User findByUsername(String username) {
        return client.findByUsername(username);
    }
}
