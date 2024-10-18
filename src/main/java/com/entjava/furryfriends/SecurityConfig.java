package com.entjava.furryfriends;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .anyRequest().authenticated() // Require authentication for all requests
                )
                .httpBasic(withDefaults()); // Enable Basic Authentication

        return http.build();
    } // POJO plain old java objects

    @Bean
    public UserDetailsService userDetailsService() {
        
        List<UserDetails> users = new ArrayList<>();

        UserDetails user = User
                .withDefaultPasswordEncoder() // Not recommended for production, use BCrypt or another encoder
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails user2 = User
                .withDefaultPasswordEncoder() // Not recommended for production, use BCrypt or another encoder
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
                
        users.add(user);

        return new InMemoryUserDetailsManager(user);
    }
}
