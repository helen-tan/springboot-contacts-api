package com.springbootcontactsapi.springbootcontactsapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests() // any http request that is caught in the filter chain needs to be authorized
            .anyRequest().authenticated() // any request needs to be authenticated
            .and()
            .httpBasic(); // these requests will be authenticated using basic authentication

        return http.build(); // return the built object (saved as a bean)
    }
}
