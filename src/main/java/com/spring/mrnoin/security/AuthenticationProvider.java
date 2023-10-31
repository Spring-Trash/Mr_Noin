package com.spring.mrnoin.security;

import com.spring.mrnoin.controller.LoginController;
import com.spring.mrnoin.repository.AccountRepository;
import com.spring.mrnoin.vo.AccountLoginVO;
import com.spring.mrnoin.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

public class AuthenticationProvider implements org.springframework.security.authentication.AuthenticationProvider {

    @Resource
    private UserDetailsService userDetailsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String userId = token.getName();
        String userPw = (String) token.getCredentials();

        AccountVO accountVO = (AccountVO) userDetailsService.loadUserByUsername(userId);

        if(passwordEncoder.matches(userPw, accountVO.getPassword())){
            System.out.println(accountVO.getAuthorities());
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
