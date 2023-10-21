package com.spring.mrnoin.service.member;

import com.spring.mrnoin.vo.MemberLoginVO;
import com.spring.mrnoin.vo.MemberVo;

public interface MemberService {
    MemberVo getOneMemberById(MemberLoginVO memberLoginVO);
}
