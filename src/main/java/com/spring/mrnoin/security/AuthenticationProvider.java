package com.spring.mrnoin.security;

import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@Slf4j
public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Resource
    private UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("AuthenticationProvider : authenticate");
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String userId = token.getName();
        String userPw = (String) token.getCredentials();

        AccountVO accountVO = (AccountVO) userDetailsService.loadUserByUsername(userId);
        log.info("rawPW : {}, encodedPW : {}", userPw, accountVO.getPassword());
        if(passwordEncoder.matches(userPw, accountVO.getPassword())){
            log.info("AccountVO ROLE : {}", accountVO.getRole());
            return new UsernamePasswordAuthenticationToken(userId, userPw, accountVO.getAuthorities());
        } else {
            throw new BadCredentialsException(accountVO.getId() + "Invalid Password");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
