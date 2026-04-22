package com.b1uffer.mysecurity.security.Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.core.Ordered;

import java.io.IOException;

/**
 * Ordered 인터페이스
 */
public class SecondFilter implements Filter, Ordered {
    @Override
    public int getOrder() {
        return 2; // 숫자가 클수록 나중에 실행된다
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Second Filter 실행");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
