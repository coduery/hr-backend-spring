package com.coduery.hr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("WebSecurityConfig spring.profiles.active: " + System.getProperty("spring.profiles.active"));  // Passed in as VM Argument
        System.out.println("WebSecurityConfig user.name: " + System.getProperty("user.name"));  // Available by default
        http
            .authorizeRequests()
                .antMatchers("/").permitAll();
    }
}
