package com.spring.mrnoin.repository.member;

import com.spring.mrnoin.vo.MemberVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

// TODO : NULL처리(Optional등)
@Mapper
public interface MemberRepository {
    @Select("select * from member where id = #{id} and password = #{password}")
    MemberVo getOneMemberById(@Param("id") String id, @Param("password") String password);
}
