package com.nlu.fit.chat.config;

import com.nlu.fit.chat.dto.mapper.UserDetailsMapper;
import com.nlu.fit.chat.respository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.lang.model.type.TypeMirror;
import java.lang.invoke.TypeDescriptor;
import java.lang.reflect.Type;

@RequiredArgsConstructor
@Configuration
public class ApplicationConfig {
    private final UserRepository userRepository;

    private final UserDetailsMapper userDetailsMapper;

    @Bean
    public UserDetailsService userDetailsService() {
        return (email) -> userRepository
                .findByEmail(email)
                .map(userDetailsMapper)
                .orElseThrow(() -> new UsernameNotFoundException("Email doesn't exist"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
}