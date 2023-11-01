package com.spring.mrnoin.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

@Component
@Slf4j
public class JwtUtil {
    @Value("${jwt.salt}")
    private String salt;

    @Value("${jwt.expmin}")
    private Long expireMin;

    // 만드는 부분, 검증 및 내용확인 부분
    public String createAuthToken(String id){
        return create(id, "authToken", expireMin);
    }

    // 로그인 성공시 JWTToken을 생성해서 반환한다.
    // JWT Token : Header + Payload + Signature
    private String create(String id, String subject, long expireMin){
        final JwtBuilder builder = Jwts.builder();
        // Header, Payload, 만료시간 설정
        builder.setSubject(subject).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin));
        // id를 담는다.
        if(id != null){
            builder.claim("user", id);
        }
        // 키를 이용해 암호화한다.
        builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());

        // 직렬화처리 encode
        final String jwt = builder.compact();
        log.debug("토큰 발행 완료 : {}", jwt);
        return jwt;
    }

    // JWT토큰을 보고 문제가 있다면 예외를 발생시킨다.
    public Map<String, Object> checkAndGetClaims(String jwt){
        // jwt decode
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
        log.debug("JWT Claims : {}", claimsJws);
        return claimsJws.getBody();
    }
}
