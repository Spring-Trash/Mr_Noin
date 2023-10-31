package com.spring.mrnoin.security;

import org.apache.el.parser.Token;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JwtTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String header = request.getHeader(AuthConstants.AUTH_HEADER);

        if(header != null){
            final String token = TokenUtils.getTokenFromHeader(header);
            if(TokenUtils.isValidToken(token)){
                return true;
            }
        }
        request.setAttribute("msg", "인증 정보 없음");
        response.sendRedirect("/");
        return false;
    }
}
