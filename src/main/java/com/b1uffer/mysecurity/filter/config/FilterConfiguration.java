package com.b1uffer.mysecurity.filter.config;

import com.b1uffer.mysecurity.filter.webflux.FirstWebFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {
    // 서블릿 기반 Filter라서 리액티브 기반(WebFlux)에서는 필터가 동작하지 않는다
//    @Bean
//    public FilterRegistrationBean<FirstFilter> firstFilterRegistration() {
//        FilterRegistrationBean<FirstFilter> firstFilterRegistration = new FilterRegistrationBean<>(new FirstFilter());
//        firstFilterRegistration.setOrder(1); // 얘를 먼저 실행하고
//        return firstFilterRegistration;
//    }
//
//    @Bean FilterRegistrationBean<SecondFilter> secondFilterRegistration() {
//        FilterRegistrationBean<SecondFilter> secondFilterRegistration = new FilterRegistrationBean<>(new SecondFilter());
//        secondFilterRegistration.setOrder(2); // 얘를 나중에 실행함
//        return secondFilterRegistration;
//    }
    @Bean
    public FirstWebFilter firstWebFilter() {
        return new FirstWebFilter();
    }
}
