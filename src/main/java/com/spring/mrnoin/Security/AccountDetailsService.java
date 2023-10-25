package com.spring.mrnoin.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsService implements UserDetailsService {

    private final AccountService accountService;

    public AccountDetailsService(AccountService accountService){
        this.accountService = accountService;
    }

    // username이 들어온다
    // 패스워드 체크는 알아서 하게 되므로 id만 갖고 들어온다

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountVO accountVO = accountService.getAcoountVOById(username);
        return User.builder()
                .username(accountVO.getUsername())
                .password(accountVO.getPassword())
                .roles(accountVO.getRole())
                .build();
    }
}
