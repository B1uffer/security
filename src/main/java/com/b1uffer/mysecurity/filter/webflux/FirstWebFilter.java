package com.b1uffer.mysecurity.filter.webflux;

import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

public class FirstWebFilter implements WebFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        System.out.println("---- WebFilter start ----");
        Mono<Void> filterChain = chain.filter(exchange).doOnTerminate(() -> {
            System.out.println("---- WebFilter end ----");
        });
        return filterChain;
    }
}
