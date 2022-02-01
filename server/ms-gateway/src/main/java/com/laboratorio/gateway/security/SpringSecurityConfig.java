package com.laboratorio.gateway.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;

@AllArgsConstructor
@EnableWebFluxSecurity
@CrossOrigin(origins = "*")
public class SpringSecurityConfig {

    private JwtAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityWebFilterChain configure(ServerHttpSecurity http) {
        return http.authorizeExchange()
                .pathMatchers("/api/security/oauth/**").permitAll()
                .pathMatchers(HttpMethod.GET,"/api/gif/").hasRole("ADMIN")
                .pathMatchers(HttpMethod.GET,"/api/gif/authuser/search").hasRole("USER")
                .pathMatchers(HttpMethod.POST,"/api/gif/authuser/create").hasRole("USER")
                .pathMatchers(HttpMethod.PUT,"/api/gif/authuser/edit").hasRole("USER")
                .pathMatchers(HttpMethod.DELETE,"/api/gif/authuser/delete/{id}").hasRole("USER")
                .pathMatchers(HttpMethod.GET, "/api/gif/giphy/trending").permitAll()
                .pathMatchers(HttpMethod.GET, "/api/gif/giphy/search").permitAll()

                .pathMatchers(HttpMethod.GET, "/api/users").hasRole("ADMIN")
                .pathMatchers(HttpMethod.GET, "/api/users/search/{username}").hasRole("ADMIN")
                .pathMatchers(HttpMethod.PUT, "/api/users/edit").hasAnyRole("ADMIN")
                .pathMatchers(HttpMethod.POST, "/api/users/create").permitAll()
                .pathMatchers("/api/users/create").hasRole("ADMIN")
                .anyExchange().authenticated()
                .and().addFilterAt(authenticationFilter, SecurityWebFiltersOrder.AUTHENTICATION)
                .csrf().disable()
                .build();
    }
}
