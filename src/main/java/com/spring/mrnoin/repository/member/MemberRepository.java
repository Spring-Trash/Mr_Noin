package com.spring.mrnoin.repository.member;

import com.spring.mrnoin.vo.MemberVo;
import org.apache.ibatis.annotations.*;

// TODO : NULL처리(Optional등)
@Mapper
public interface MemberRepository {
    @Select("select * from member where id = #{id} and password = #{password}")
    MemberVo getOneMemberToLogin(@Param("id") String id, @Param("password") String password);

    @Select("select count(*) from member where id = #{id}")
    int getOneMemberById(@Param("id") String id);

    @Insert("insert into member(id, password, nickname, email, age, status) value(#{id}, #{password}, #{nickname}, #{email}, #{age}, #{status})")
    int signUp(@Param("id") String id,
               @Param("password") String password,
               @Param("nickname") String nickname,
               @Param("email") String email,
               @Param("age") int age,
               @Param("status") String status);

    @Update("update member set password=#{password}, nickname=#{nickname}, email=#{email}, age=#{age}, status=#{status} where id = #{id}")
    int memberUpdate(
               @Param("id") String id,
               @Param("password") String password,
               @Param("nickname") String nickname,
               @Param("email") String email,
               @Param("age") int age,
               @Param("status") String status);
}
