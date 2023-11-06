package com.spring.mrnoin.handler;

import com.spring.mrnoin.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

// 로그인 성공시 SecurityContextHolder에 등록, 메인페이지로 리다이렉션
@Configuration
@Slf4j
@RequiredArgsConstructor
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("LoginSuccessHandler : onAuthenticationSuccess");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //final AccountVO accountVO = (AccountVO) authentication.getPrincipal();

        response.sendRedirect("/");
    }
}
