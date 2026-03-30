package com.b1uffer.mysecurity.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class FirstFilter implements Filter {
    // Filter 초기화 작업을 하는 init 메서드
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("---- FirstFilter init ----");
    }

    // 필터 동작 로직을 담당하는 doFilter 메서드
    // 전처리 -> 다음 필터 호출 -> 후처리
    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- FirstFilter Filter start ----");
        filterChain.doFilter(servletRequest, servletResponse); // 다음 필터로 요청을 전달한다
        System.out.println("---- FirstFilter Filter end ----");
    }

    // 종료시 자원 해제를 하는 destroy 메서드
    // 자원을 반납함
    @Override
    public void destroy() {
        System.out.println("---- FirstFilter destroy ----");
        Filter.super.destroy();
    }
}
