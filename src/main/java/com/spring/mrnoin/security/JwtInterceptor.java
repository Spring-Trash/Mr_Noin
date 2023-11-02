package com.spring.mrnoin.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@Component
@Slf4j
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("JwtInterceptor : preHandle");
//        if(request.getMethod().equals("OPTIONS")){
//            return true;
//        }
        Enumeration headerNames = request.getHeaderNames();
//        while(headerNames.hasMoreElements()){
//            String header = headerNames.nextElement().toString();
//            log.info("Request Header : {} = {}", header, request.getHeader(header));
//        }
        // requst의 header에서 jwt token 검출
        String authToken = request.getHeader(AuthConstants.AUTH_HEADER);
        log.info("경로 : {}, 토큰 : {}, 토큰2 : {}", request.getServletPath(), authToken);

        if(authToken != null){
            jwtUtil.checkAndGetClaims(authToken);
            return true;
        } else {
            response.sendRedirect("/error/unauthorized");
            return false;
        }
    }
}
