package com.b1uffer.mysecurity.filter.config;

import com.b1uffer.mysecurity.filter.FirstFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegistration() {

    }
}
