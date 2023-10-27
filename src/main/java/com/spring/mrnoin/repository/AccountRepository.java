package com.spring.mrnoin.repository;

import com.spring.mrnoin.vo.AccountLoginVO;
import com.spring.mrnoin.vo.AccountVO;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountRepository {
    @Select("select * from account where id = #{id} and password = #{password}")
    AccountVO getOneAccountToLogin(AccountLoginVO accountLoginVO);

    @Select("select * from account where id = #{id}")
    AccountVO getOneAccountById(@Param("id") String id);

    @Insert("insert into account(id, password, nickname, email, age, status, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, role)" +
            "values(#{id}, #{password}, #{nickname}, #{email}, #{age}, #{status}, #{isAccountNonExpired}, #{isAccountNonLocked}, #{isCredentialsNonExpired}, #{isEnabled}, #{role})")
    int signUp(AccountVO accountVO);

    @Update("update member set password=#{password}, nickname=#{nickname}, email=#{email}, age=#{age}, status=#{status} where id = #{id}")
    int accountUpdate(AccountVO accountVO);
}
