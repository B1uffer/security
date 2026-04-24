package com.b1uffer.mysecurity.security.custom;

import org.jspecify.annotations.Nullable;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // authentication에서 username, password 가져오기
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        // 커스텀 인증 로직 구현
        if("customUser".equals(username) && "customPassword".equals(password)) {
            /**
             * UsernamePasswordAuthenticationToken은 AbstractAuthenticationToken을 extends하며,
             * AbstractAuthenticationToken은 Authentication을 implements 한다
             */
            return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>()); // 토큰 발급
        } else {
            throw new BadCredentialsException("인증 실패");
        }
    }

    /**
     * 로그인 요청이 오면 ProviderManager가 모든 Provider를 순회하면서 supports() 메서드를 먼저 호출한다
     * 이후 return값에 대한 타입을 처리 가능한지 체크하고
     * true인 Provider에 대해서만 위의 authenticate() 메서드를 실행한다
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
