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
    public MemberVo getOneMemberToLogin(MemberLoginVO memberLoginVO) {
        return memberRepository.getOneMemberToLogin(memberLoginVO.getId(), memberLoginVO.getPassword());
    }

    @Override
    public int getOneMemberById(String id) {
        return memberRepository.getOneMemberById(id);
    }

    @Override
    public int signUp(MemberVo memberVo) {
        return memberRepository.signUp(
                memberVo.getId(),
                memberVo.getPassword(),
                memberVo.getNickname(),
                memberVo.getEmail(),
                memberVo.getAge(),
                memberVo.getStatus());
    }

    @Override
    public int memberUpdate(MemberVo memberVo) {
        return memberRepository.memberUpdate(
                memberVo.getId(),
                memberVo.getPassword(),
                memberVo.getNickname(),
                memberVo.getEmail(),
                memberVo.getAge(),
                memberVo.getStatus()
        );
    }


}
