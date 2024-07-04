package com.bob.examplanning__.Configuration;

import com.bob.examplanning__.Configuration.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomAuthenticationProvider customAuthenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http

                .authorizeHttpRequests(auth->{
                    auth.requestMatchers("/assets/**").permitAll(); // Autoriser l'accès aux fichiers statiques
                    auth.requestMatchers("/exam/**").permitAll();
                    auth.anyRequest().authenticated();
                })

//                .oauth2Login(Customizer.withDefaults())
                .formLogin(form -> form
                        .loginPage("/exam/Showinglogin") // Specify custom login page
                        .defaultSuccessUrl("/exam/Accueil", true)
                        .permitAll()
                )
//                .exceptionHandling(exceptionHandling -> exceptionHandling
//                        .accessDeniedHandler((request, response, accessDeniedException) -> {
//                            response.sendRedirect("/errorPage");
//                        })
//                )
                .authenticationProvider(customAuthenticationProvider)
                .build();
    }
}