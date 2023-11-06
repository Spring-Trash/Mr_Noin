package com.spring.mrnoin.repository;

import com.spring.mrnoin.vo.AccountLoginVO;
import com.spring.mrnoin.vo.AccountVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface AccountRepository {
    @Select("select * from account where id = #{id} and password = #{password}")
    AccountVO getOneAccountToLogin(AccountLoginVO accountLoginVO);

    @Select("select * from account where id = #{id}")
    AccountVO getOneAccountById(@Param("id") String id);

    @Insert("insert into account(id, password, name, nickname, email, age, status, isAccountNonExpired, isAccountNonLocked, isCredentialsNonExpired, isEnabled, role)" +
            "values(#{id}, #{password}, #{name}, #{nickname}, #{email}, #{age}, #{status}, #{isAccountNonExpired}, #{isAccountNonLocked}, #{isCredentialsNonExpired}, #{isEnabled}, #{role})")
    int signUp(AccountVO accountVO);

    @Update("update account set password=#{password}, name=#{name}, nickname=#{nickname}, email=#{email}, age=#{age}, status=#{status} where id = #{id}")
    int accountUpdate(AccountVO accountVO);
}
