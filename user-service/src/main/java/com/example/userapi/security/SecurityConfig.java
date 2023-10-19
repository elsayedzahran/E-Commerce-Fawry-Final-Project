package com.example.userapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    //this method to get users from Database and also get their roles
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){



        return new JdbcUserDetailsManager(dataSource);
    }

    //This method to add Roles Authorizations
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        //adding roles Auth

        http.authorizeHttpRequests(configure->
                configure
                        .requestMatchers(HttpMethod.GET,"/**").permitAll()


        );
        //to tell Spring that we use Basic Authentication
        http.httpBasic(withDefaults());

        //Disable CSRF (Cross Site Request Forgery)
        http.csrf(csrf->csrf.disable());

        return http.build();
    }


}
