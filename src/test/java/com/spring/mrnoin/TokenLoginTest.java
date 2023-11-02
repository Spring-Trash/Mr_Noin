package com.spring.mrnoin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class TokenLoginTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void testLogin() throws Exception{
        MockHttpServletRequestBuilder requestBuilder = post("/loginconfirm").param("id", "admin").param("password", "admin");
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        log.info("HTTP Response Status : {}", resultActions.andDo(print()));
    }

    @Test
    public void testGeiInfoSuccess() throws Exception{
        String token = jwtUtil.createAuthToken("admin");

        MockHttpServletRequestBuilder requestBuilder = get("/").header("jwt-auth-token", token);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        log.info("HTTP Response Status : {}", resultActions.andDo(print()));
    }

    @Test
    public void testGetInfoFail() throws Exception{
        String token = "fdsf";

        MockHttpServletRequestBuilder requestBuilder = get("/").header("jwt-auth-token", token);
        ResultActions resultActions = mockMvc.perform(requestBuilder);

        log.info("HTTP Response Status : {}", resultActions.andDo(print()));
    }
}
