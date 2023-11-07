package com.spring.mrnoin.service;

import com.spring.mrnoin.repository.AccountRepository;
import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class AccountServiceimpl implements AccountService{

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountVO getAccountVOById(String username) {
        log.info("AccountService : getAccountVOById");
        return (AccountVO) userDetailsService.loadUserByUsername(username);
    }

    @Override
    public int signUp(AccountVO accountVO) {
        log.info("AccountService : signUp");
        accountVO.setAccountNonExpired(true);
        accountVO.setAccountNonLocked(true);
        accountVO.setCredentialsNonExpired(true);
        accountVO.setEnabled(true);
        accountVO.setRole("USER");
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(accountVO.getRole());
        authorities.add(grantedAuthority);

        accountVO.setAuthorities(authorities);
        accountVO.setPassword(passwordEncoder.encode(accountVO.getPassword()));
        return accountRepository.signUp(accountVO);
    }

    @Override
    public int accountUpdate(AccountVO accountVO) {
        log.info("AccountService : accountUpdate");
        AccountVO origin = (AccountVO) userDetailsService.loadUserByUsername(accountVO.getId());
        if(accountVO.getPassword() != null || accountVO.getPassword().equals("")){
            origin.setPassword(passwordEncoder.encode(accountVO.getPassword()));
        }
        if(!accountVO.getEmail().equals(origin.getEmail())){
            origin.setEmail(accountVO.getEmail());
        }
        if(accountVO.getAge() != origin.getAge()){
            origin.setAge(accountVO.getAge());
        }
        if(!accountVO.getStatus().equals(origin.getStatus())){
            origin.setStatus(accountVO.getStatus());
        }
        if(!accountVO.getNickname().equals(origin.getNickname())){
            origin.setNickname(accountVO.getNickname());
        }
        if(!accountVO.getName().equals(origin.getName())){
            origin.setName(accountVO.getName());
        }

        return accountRepository.accountUpdate(origin);
    }
}
