package com.jq.config;

import com.jq.utils.JQUtils;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JQWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+JQUtils.getImagePath());
        
        super.addResourceHandlers(registry);

    }
}
