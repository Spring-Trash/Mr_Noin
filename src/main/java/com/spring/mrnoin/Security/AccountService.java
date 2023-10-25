package com.spring.mrnoin.Security;

import com.spring.mrnoin.vo.AccountLoginVO;

public interface AccountService {
    AccountVO getAcoountVOById(String username);
    AccountVO getOneAccountToLogin(AccountLoginVO accountLoginVO);
    int signUp(String userId, String password, String nickName, String email, int age, String status);

    int updateAccount(AccountVO accountVO);
}
