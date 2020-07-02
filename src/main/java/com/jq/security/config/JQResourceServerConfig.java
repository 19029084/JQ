package com.jq.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableResourceServer
public class JQResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Autowired
    private JQAuthenticationEntryPoint jqAuthenticationEntryPoint;
    
    @Autowired
    private JQAccessDeniedHandler jqAccessDeniedHandler;
    
    @Autowired
    TokenStore tokenStore;
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        
        http.csrf().disable()
        .exceptionHandling()//.authenticationEntryPoint(jqAuthenticationEntryPoint)
        .and()
        .authorizeRequests()
        .antMatchers("/api/v1/login","/swagger-ui.html","/swagger-resources/**","/webjars/**","/v2/api-docs/**").permitAll()
        .anyRequest().authenticated();

    }


    public void configure(ResourceServerSecurityConfigurer resource) throws Exception {

        //这里把自定义异常加进去
        resource.tokenStore(tokenStore).authenticationEntryPoint(jqAuthenticationEntryPoint)
            .accessDeniedHandler(jqAccessDeniedHandler);
    }

    private static class OAuth2RequestedMatcher implements RequestMatcher {
        @Override
        public boolean matches(HttpServletRequest request) {
            String auth = request.getHeader("Authorization");
            boolean haveOauth2Token = (auth != null) && auth.startsWith("Bearer");
            boolean haveAccessToken = request.getParameter("access_token")!=null;
            return haveOauth2Token || haveAccessToken;
        }
    }
}

