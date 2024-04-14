package com.project.flights.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        http.csrf().disable().httpBasic();
        http.authorizeHttpRequests().anyRequest().authenticated().and().formLogin().and().logout().logoutUrl("/logout");
        return http.build();
    }
     @Bean
    public UserDetailsService inMemoryUserDetailsManager(PasswordEncoder passwordEncoder){
        UserDetails user1= User.withUsername("user").password(passwordEncoder.encode("1234")).roles("User").build();

        UserDetails user2= User.withUsername("admin").password(passwordEncoder.encode("1234")).roles("Admin").build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
      @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
