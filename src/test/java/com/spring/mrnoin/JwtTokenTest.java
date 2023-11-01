package com.spring.mrnoin;

import com.spring.mrnoin.security.JwtUtil;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class JwtTokenTest {

    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void JwtTokenCreateTest(){
        String id = "admin";
        String token = jwtUtil.createAuthToken(id);
        assertNotNull(token);
        log.info(token);
    }

    @Test
    public void contentTest(){
        String id = "admin";
        String token = jwtUtil.createAuthToken(id);
        Map<String, Object> content = jwtUtil.checkAndGetClaims(token);

        assertEquals(content.get("sub"), "authToken");
        assertEquals(content.get("user"), id);
    }

    @Test
    public void wrongTokenTest(){
        String fakeToken = "fakeToken";
        assertThrows(MalformedJwtException.class, () -> {
            jwtUtil.checkAndGetClaims(fakeToken);
        });
    }
}
