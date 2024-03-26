package com.nlu.fit.chat.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(IGNORED_PATH);
    }

    public static final String[] IGNORED_PATH = new String[]{
            "/api/v*/auth/register",
            "/api/v*/auth/login",
            "/api/v*/auth/verify**",
            "/api/v*/verify/**",
            "/",
            "/api/v1/refresh-token/self",
            "/api/v1/files/**",
            "/api/v1/images/**",
            "/api/v1/accounts**",
            "/api/v1/auth/forgot-password",
            "/api/v1/auth/verify-forgot-password**",
            "/api/v1/posts**"
    };

}