package com.b1uffer.mysecurity.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain webfluxChain(ServerHttpSecurity http) {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(ex -> ex
                        .pathMatchers("/", "/public/**").permitAll()
                        .pathMatchers("/admin/**").hasRole("ADMIN")
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password("{noop}pass").roles("USER").build();
        UserDetails admin = User.withUsername("admin")
                .password("{noop}pass").roles("ADMIN").build();

        return new MapReactiveUserDetailsService(user, admin);
    }

    /**
     * 서블릿 기반(Spring MVC) Spring Security FilterChain 예
     */

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/public/**").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .anyRequest().authenticated())
//                .formLogin(login -> login
//                        /**
//                         * loginPage 메서드를 집어넣음으로 login 컨트롤러와 정적페이지를 만들어줘야함
//                         */
//                        .loginPage("/login").permitAll()
//                        .defaultSuccessUrl("/", true))
//                .logout(logout -> logout
//                        .logoutUrl("/logout"));
//
//        return http.build();
//    }

//    @Bean
//    UserDetailsService users() {
//        UserDetails user = User.withUsername("user")
//                .password("{noop}pass")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withUsername("admin")
//                .password("{noop}pass")
//                .roles("ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}
