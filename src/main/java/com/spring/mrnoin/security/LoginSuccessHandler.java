package com.spring.mrnoin.security;

import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
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
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        log.info("LoginSuccessHandler : onAuthenticationSuccess");
        // JWT처리시 SecurityContextHolder에 인증정보를 보관할 필요가 없다.
        SecurityContextHolder.getContext().setAuthentication(authentication);
        //final AccountVO accountVO = (AccountVO) authentication.getPrincipal();
        // 인증 성공시 정보가 넘어오고, 해당 정보로 jwt 토큰을 발행, response header에 탑재

        //response.addHeader(AuthConstants.AUTH_HEADER, AuthConstants.TOKEN_TYPE + " " + token);
        response.sendRedirect("/");
    }
}
