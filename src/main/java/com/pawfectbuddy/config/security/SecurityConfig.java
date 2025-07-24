package com.pawfectbuddy.config.security;

import com.pawfectbuddy.service.RouteServiceInterface;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserCredentialsSecurity userCredentialsSecurity;
    @Autowired
    private RouteServiceInterface routeService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userCredentialsSecurity)
                .passwordEncoder(passwordEncoder());
        return builder.build();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) {
        try {
            http.csrf(AbstractHttpConfigurer::disable);
            http.authorizeHttpRequests((requests) -> {
                        for (Map.Entry<String, List<String>> entry : routeService.getRouteRoleMapping().entrySet()) {
                            String route = entry.getKey();
                            List<String> roles = entry.getValue();
                            String[] roleArray = roles.toArray(new String[0]);
                            requests.requestMatchers(route).hasAnyAuthority(roleArray);
                        }
                        requests
                                .requestMatchers("/login.xhtml", "/").permitAll()
                                .requestMatchers("/jakarta.faces.resource/**").permitAll()
                                .anyRequest()
                                .authenticated();
                    })
                    .anonymous((anonymous) -> anonymous.principal("guestUser").authorities("ROLE_GUEST"))
                    .formLogin((formLogin) -> formLogin
                            .loginPage("/login.xhtml").permitAll()
                            .failureUrl("/login.xhtml?error=true")
                            .defaultSuccessUrl("/profile.xhtml")
                    )
                    .logout((logout) -> logout
                            .logoutUrl("/logout")
                            .logoutSuccessUrl("/index.xhtml")
                            .deleteCookies("JSESSIONID")
                    )
                    .exceptionHandling((exception)-> exception.accessDeniedPage("/403.xhtml"));
            return http.build();
        } catch (Exception ex) {
            throw new BeanCreationException("Wrong spring security configuration", ex);
        }
    }
}
