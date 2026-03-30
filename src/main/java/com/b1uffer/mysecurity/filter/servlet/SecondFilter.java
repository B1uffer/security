package com.b1uffer.mysecurity.filter.servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("---- SecondFilter init ----");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("---- SecondFilter start ----");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("---- SecondFilter end ----");
    }

    @Override
    public void destroy() {
        System.out.println("---- SecondFilter destroy ----");
        Filter.super.destroy();
    }
}
