package com.b1uffer.mysecurity.security.config;

import com.b1uffer.mysecurity.security.Filter.FirstFilter;
import com.b1uffer.mysecurity.security.Filter.SecondFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<FirstFilter> firstFilterRegistration() {
        FilterRegistrationBean<FirstFilter> registration =
                new FilterRegistrationBean<>(new FirstFilter());

        registration.setOrder(1); // 먼저 실행하기
        registration.addUrlPatterns("/api/*"); // 특정 경로에만 적용하기
        return registration;
    }

    @Bean
    public FilterRegistrationBean<SecondFilter> secondFilterRegistration() {
        FilterRegistrationBean<SecondFilter> registration =
                new FilterRegistrationBean<>(new SecondFilter());

        registration.setOrder(2); // 두번째로 실행하기
        return registration;
    }
}
