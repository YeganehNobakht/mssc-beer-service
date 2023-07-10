package com.bmc.msscbeerservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Masoumeh Yeganeh
 * @created 10/07/2023
 */
public class WebSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }
}
