package com.idk.covid19.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /** User Role of ADMIN is required to access this Service's API, while a role of VIEW can view the Coronavirus stats */
    public static final String VIEW = "VIEW";
    public static final String ADMIN = "ADMIN";

    @Autowired
    private Covid19Properties properties;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable().authorizeRequests()
                .antMatchers("/admin.html/**").hasRole(ADMIN)
//                .antMatchers("/api/**").hasAnyRole(VIEW, ADMIN)
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails view =
                User.withDefaultPasswordEncoder()
                        .username(properties.getAdminAccess().getUserName())
                        .password(properties.getAdminAccess().getUserPassword())
                        .roles(VIEW)
                        .build();

        UserDetails admin =
                User.withDefaultPasswordEncoder()
                        .username(properties.getAdminAccess().getAdminName())
                        .password(properties.getAdminAccess().getAdminPassword())
                        .roles(ADMIN)
                        .build();

        return new InMemoryUserDetailsManager(view, admin);
    }
}
