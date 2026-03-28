package com.b1uffer.mysecurity.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {
    @GetMapping("/")
    @ResponseBody
    public Mono<String> home() {
        return Mono.just("home");
    }

    /**
     * 리액티브(WebFlux) 기반 FilterChain을 사용할 때
     * FilterChain에 formLogin()과 httpBasic()을 둘 다 사용할때
     * 403이 뜰 수 있다
     */
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/panel")
    @ResponseBody
    public Mono<String> admin() {
        return Mono.just("admin");
    }
}
