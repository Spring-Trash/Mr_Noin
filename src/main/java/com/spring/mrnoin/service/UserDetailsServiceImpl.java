package com.spring.mrnoin.service;

import com.spring.mrnoin.repository.AccountRepository;
import com.spring.mrnoin.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;
    
    // DB에서 id로 조회하고 정보 반환
    // 원래 사용자가 없는 경우, pw가 맞지 않는 경우를 여기서 구현해야 한다.
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        log.info("UserDetailsService : loadUserByUsername");
        return accountRepository.getOneAccountById(id);
    }
}
