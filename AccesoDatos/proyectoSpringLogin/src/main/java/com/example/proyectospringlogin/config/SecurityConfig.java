package com.example.proyectospringlogin.config;

import com.example.proyectospringlogin.service.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests( (authz) ->
                        authz.requestMatchers("/", "/register").permitAll()
                                .requestMatchers("/users/**").authenticated()
                        )
                .formLogin(form ->
                        form.loginPage("/login")
                        .loginProcessingUrl("/")
                        .permitAll()
                )

                .logout(logout ->
                        logout.permitAll()
                            .logoutSuccessUrl("/")
                        )

                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return new UsuarioService();
    }

}
