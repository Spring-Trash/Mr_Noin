package com.spring.mrnoin.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Configuration
public class LoginFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        // Exception들을 처리한다.
        System.out.println("Login Failed ------------------------");
        System.out.println(exception);

        request.getRequestDispatcher("/tologinpage?msg=" + URLEncoder.encode("ID, PW를 확인해주세요", "utf-8")).forward(request,response);
    }
}
