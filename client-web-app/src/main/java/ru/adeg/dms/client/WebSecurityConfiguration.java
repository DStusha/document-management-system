package ru.adeg.dms.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.adeg.dms.security.TokenAuthenticationFilter;
import ru.adeg.dms.security.TokenAuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled=true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Value("${token.key}")
    private String tokenKey;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers()
                .frameOptions()
                .sameOrigin()
                .and()
                .csrf()
                .disable()
                .addFilterAfter(tokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean(name = "tokenAuthenticationFilter")
    public TokenAuthenticationFilter tokenAuthenticationFilter() {
        return new TokenAuthenticationFilter(tokenService());
    }

    @Bean(name = "tokenService")
    public TokenAuthenticationService tokenService() {
        TokenAuthenticationService tokenService = new TokenAuthenticationService();
        tokenService.setKey(tokenKey);
        return tokenService;
    }
}
