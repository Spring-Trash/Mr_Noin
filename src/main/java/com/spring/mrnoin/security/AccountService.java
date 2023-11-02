package com.spring.mrnoin.security;

import com.spring.mrnoin.vo.AccountVO;

public interface AccountService {
    AccountVO getAccountVOById(String username);
    int signUp(AccountVO accountVO);

    int accountUpdate(AccountVO accountVO);
}
