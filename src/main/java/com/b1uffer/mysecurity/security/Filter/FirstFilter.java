package com.b1uffer.mysecurity.security.Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.core.annotation.Order;

import java.io.IOException;

/**
 * @Order 애너테이션
 * @Order는 해당 필터를 우선적으로 실행하게끔 한다
 * 괄호안의 숫자가 작을수록 우선순위가 높다, 즉 먼저 실행된다
 */
@Order(1)
public class FirstFilter implements Filter { // Filter import 클래스는 servlet이다
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("First Filter 실행");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
