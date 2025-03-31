package com.app.justbuy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class JustbuySecurityConfig {

    private UserDetailsService userDetailsService;

    // BCryptPasswordEncoder Bean to be used in password encoding
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public JustbuySecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/private/*").hasRole("ADMIN")
                        .requestMatchers("/api/v1/buyer/*").hasRole("BUYER")
                        .requestMatchers("/api/v1/seller/*").hasAnyRole("SELLER","ADMIN")
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                        .deleteCookies("JSESSIONID"))
                .httpBasic(withDefaults());
        return http.build();
    }

   /* @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/login").permitAll()
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider())
                .build();
    }*/

  /*  @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(Customizer.withDefaults())
                .build();
    }*/

    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }*/

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }


    // Define the security filter chain for handling HTTP security rules
    /*@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // Define which requests require authentication and authorization
        http
                .csrf(AbstractHttpConfigurer::disable) // CSRF protection is disabled for simplicity, reconsider enabling it in production
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasRole("ADMIN")  // Only ADMIN role can access /admin/*
                        .requestMatchers("/buyer/**").hasRole("BUYER")  // Only BUYER role can access /buyer/*
                        .requestMatchers("/seller/**").hasRole("SELLER")     // Only SELLER role can access /seller/*
                        .requestMatchers("/public/**").permitAll()       // Public endpoints that don't require authentication
                        .anyRequest().authenticated()                    // All other requests require authentication
                )
                .formLogin(form -> form
                        .loginPage("")                             // Custom login page
                        .permitAll()                                     // Allow anyone to access the login page
                )
                .logout(logout -> logout
                        .logoutUrl("/my/logout")  // Custom logout URL
                        .logoutSuccessUrl("/my/index") // Custom redirect URL after logout
                        .invalidateHttpSession(true) // Invalidate session
                        .permitAll()
                );

        return http.build(); // Return the configured SecurityFilterChain
    }*/


}
