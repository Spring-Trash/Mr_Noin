package com.spring.mrnoin.security;

import com.spring.mrnoin.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    private final AccountRepository accountRepository;
    
    // DB에서 id로 조회하고 정보 반환
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        return accountRepository.getOneAccountById(id);
    }
}
