package com.jq.security.config;

import com.jq.security.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class JQWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    
    //@Autowired 
    //JQAuthenticationFailureHandler jqAuthenticationFailureHandler;
    
    //@Autowired 
    //JQAuthenticationSuccessHandler jqAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
    	 http.csrf().disable();
    	 http.authorizeRequests()
    	     .antMatchers("/oauth/**","/api/v1/login","/swagger-ui.html","/swagger-resources/**","/webjars/**","/v2/api-docs/**").permitAll()
    	     .anyRequest().authenticated()
    	     .and()
    	     .formLogin();//.loginPage("/login").failureUrl("/login?error");
        //http.authorizeRequests()
        //	 .anyRequest().authenticated()
        //        .and()
        //        .httpBasic()
                //.formLogin().loginPage("/api/v1/login").failureUrl("/login-error")                
        //        .and()
        //        .csrf().disable();
    }

}

