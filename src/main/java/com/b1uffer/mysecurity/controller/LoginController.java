package com.b1uffer.mysecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

@Controller
public class LoginController {
    @GetMapping("/login")
    public Mono<String> login() {
        return Mono.just("login");
    }

    @GetMapping("/me")
    @ResponseBody
    public Mono<String> me(Authentication authentication) {
        if (authentication == null) {
            return Mono.just("anonymous");
        }
        return Mono.just(authentication.getName() + " / " + authentication.getAuthorities());
    }
}
