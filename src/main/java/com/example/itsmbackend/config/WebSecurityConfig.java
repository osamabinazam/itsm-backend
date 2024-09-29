package com.example.itsmbackend.config;

import com.example.itsmbackend.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * The WebSecurityConfig class is responsible for configuring the security settings for the application.
 * It is annotated with @Configuration to indicate that it is a configuration class.
 * It is annotated with @EnableWebSecurity to enable Spring Security features.
 * It is annotated with @EnableMethodSecurity to enable method-level security.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;

    /**
     * Constructs a new WebSecurityConfig with the given UserDetailsServiceImpl.
     *
     * @param userDetailsService The UserDetailsServiceImpl to use for user details.
     */
    @Autowired
    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /**
     * Configures the security settings for the application.
     *
     * @param http The HttpSecurity object to configure.
     * @return A SecurityFilterChain object representing the security filter chain.
     * @throws Exception If an error occurs while configuring the security settings.
     */
    @SuppressWarnings("deprecation")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception{

        AuthenticationManagerBuilder auth =  http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        http
                .authorizeRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers("/public/api/auth/register").permitAll()
                            .requestMatchers("/public/api/auth/login").permitAll()
                            .requestMatchers("/public/api/health").permitAll()
                            .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    /**
     * Creates a new PasswordEncoder bean.
     *
     * @return A PasswordEncoder object.
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * Creates a new AuthenticationManager bean.
     *
     * @param http The HttpSecurity object to use for authentication.
     * @return An AuthenticationManager object.
     * @throws Exception If an error occurs while creating the AuthenticationManager.
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth =
            http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return auth.build();
    }
}
