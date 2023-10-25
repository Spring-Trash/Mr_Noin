package com.spring.mrnoin.security;

import com.spring.mrnoin.vo.AccountLoginVO;
import org.springframework.security.core.userdetails.User;

public interface AccountService {
    AccountVO getAcoountVOById(String username);
    User getOneAccountToLogin(AccountLoginVO accountLoginVO);
    int signUp(String userId, String password, String nickName, String email, int age, String status);

    int updateAccount(AccountVO accountVO);
}
