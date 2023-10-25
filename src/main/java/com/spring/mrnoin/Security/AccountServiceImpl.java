package com.spring.mrnoin.security;

import com.spring.mrnoin.vo.AccountLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountVO getAcoountVOById(String username) {
        AccountVO accountVO = accountRepository.getOneAccountById(username);
        return accountVO;
    }

    @Override
    public User getOneAccountToLogin(AccountLoginVO accountLoginVO) {
        accountLoginVO.setPassword(passwordEncoder.encode(accountLoginVO.getPassword()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();

        return principal;
    }

    @Override
    public int signUp(String userId, String password, String nickName, String email, int age, String status) {
        Collection<UserAuthority> tempAuthoritys = new ArrayList<>();
        tempAuthoritys.add(new UserAuthority());
        AccountVO accountVO = new AccountVO(userId, passwordEncoder.encode(password), nickName, email, age, status, true, true, true, true, "USER", tempAuthoritys);
        int result = accountRepository.signUp(accountVO);
        return result;
    }

    @Override
    public int updateAccount(AccountVO accountVO) {
        return accountRepository.accountUpdate(accountVO);
    }
}
