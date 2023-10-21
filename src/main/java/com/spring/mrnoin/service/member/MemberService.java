package com.spring.mrnoin.service.member;

import com.spring.mrnoin.vo.MemberLoginVO;
import com.spring.mrnoin.vo.MemberVo;

public interface MemberService {
    MemberVo getOneMemberToLogin(MemberLoginVO memberLoginVO);
    int getOneMemberById(String id);
    int signUp(MemberVo memberVo);
    int memberUpdate(MemberVo memberVo);
}
