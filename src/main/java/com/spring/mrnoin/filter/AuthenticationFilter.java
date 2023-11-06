package com.spring.mrnoin.filter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Slf4j
// 로그인시 여기로 요청이 온다.
// id, pw 기반으로 UserPasswordAuthenticationToken 발급
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public PasswordEncoder passwordEncoder;

    public AuthenticationFilter(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder){
        super.setAuthenticationManager(authenticationManager);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        // id, pw 기반으로 UsernamePAsswordAuthenticationToken 발급
        // UsernamePasswordAuthenticationToken principal : id, credential : password, detail(object) -> token context
        log.info("AuthenticationFilter : attemptAuthentication");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(request.getParameter("id"), request.getParameter("password"));
        log.info("id : {}, pw : {}", request.getParameter("id"), request.getParameter("password"));
        setDetails(request, token);
        return this.getAuthenticationManager().authenticate(token);
    }
}
