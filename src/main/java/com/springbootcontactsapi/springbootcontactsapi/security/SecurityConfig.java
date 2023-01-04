package com.springbootcontactsapi.springbootcontactsapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application
public class SecurityConfig {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests() // any http request that is caught in the filter chain needs to be authorized
            .anyRequest().authenticated() // any request needs to be authenticated
            .and()
            .httpBasic() // these requests will be authenticated using basic authentication
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); // Spring Security will not create a HTTP session (servers to maintain user identity and to store user-specific data during multiple request/response interactions)

        return http.build(); // return the built object (saved as a bean)
    }

    @Bean
    public UserDetailsService users() {
        UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("abc123!!")) // * passwords should never be stored as plain text
            .roles("ADMIN")
            .build();

        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder.encode("abc123!!")) // * passwords should never be stored as plain text
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
