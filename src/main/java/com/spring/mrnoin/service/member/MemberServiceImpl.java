package com.spring.mrnoin.service.member;

import com.spring.mrnoin.repository.member.MemberRepository;
import com.spring.mrnoin.vo.MemberLoginVO;
import com.spring.mrnoin.vo.MemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;
    @Override
    public MemberVo getOneMemberById(MemberLoginVO memberLoginVO) {
        return memberRepository.getOneMemberById(memberLoginVO.getId(), memberLoginVO.getPassword());
    }
}
