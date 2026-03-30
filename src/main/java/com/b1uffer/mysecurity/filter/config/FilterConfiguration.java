package com.b1uffer.mysecurity.filter.config;

import com.b1uffer.mysecurity.filter.FirstFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    // 서블릿 기반 Filter라서 리액티브 기반(WebFlux)에서는 필터가 동작하지 않는다
    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegistration() {
        FilterRegistrationBean<FirstFilter> firstFilterRegistration = new FilterRegistrationBean<>(new FirstFilter());
        return firstFilterRegistration;
    }
}
