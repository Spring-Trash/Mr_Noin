package com.spring.mrnoin.security;

import com.spring.mrnoin.repository.AccountRepository;
import com.spring.mrnoin.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceimpl implements AccountService{

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public AccountVO getAccountVOById(String username) {
        return (AccountVO) userDetailsService.loadUserByUsername(username);
    }

    @Override
    public int signUp(AccountVO accountVO) {
        accountVO.setAccountNonExpired(true);
        accountVO.setAccountNonLocked(true);
        accountVO.setCredentialsNonExpired(true);
        accountVO.setEnabled(true);
        accountVO.setRole("USER");
        accountVO.setPassword(passwordEncoder.encode(accountVO.getPassword()));
        System.out.println("signUp--------------------------------");
        return accountRepository.signUp(accountVO);
    }
}
