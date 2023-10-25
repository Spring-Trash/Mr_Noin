package com.spring.mrnoin.Security;

import com.spring.mrnoin.vo.AccountLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
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
    public AccountVO getOneAccountToLogin(AccountLoginVO accountLoginVO) {
        accountLoginVO.setPassword(passwordEncoder.encode(accountLoginVO.getPassword()));
        AccountVO rtnAccountVO = accountRepository.getOneAccountToLogin(accountLoginVO);
        return rtnAccountVO;
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
