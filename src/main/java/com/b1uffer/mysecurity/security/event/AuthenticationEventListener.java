package com.b1uffer.mysecurity.security.event;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener {
    @EventListener
    public void handleSuccess(AuthenticationSuccessEvent event) {
        System.out.println("로그인 성공 : " + event.getAuthentication().getName());
    }

    /**
     * AuthenticationFailureEvent는 AbstractAuthenticationFailureEvent 클래스 형태로
     * 다른 AuthenticationFailureEvent들에 상속되어 사용할 수 있다
     * FailureEvent를 여러개로 쪼개놓았음, 구체적으로 사용할 수 있다
     */
    @EventListener
    public void handleFailure(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println("로그인 실패" + event.getException().getMessage());
    }
}
