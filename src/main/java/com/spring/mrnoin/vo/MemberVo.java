package com.spring.mrnoin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberVo {
    @NotNull
    @NotBlank(message = "아이디를 입력해주세요.")
    @Size(min = 4, max = 20, message = "아이디는 최소 4자, 최대 20자입니다.")
    private String id;
    @NotNull
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 8, max = 20, message = "비밀번호는 최소 8자, 최대 20자입니다.")
    private String password;
    @NotNull
    @NotBlank(message = "닉네임을 입력해주세요.")
    @Size(min = 2, max = 20, message = "닉네임은 최소 2자, 최대 20자입니다.")
    private String nickname;
    @NotNull
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotNull
    @Range(min = 18, max = 100, message = "18~100살만 가입 가능합니다.")
    private int age;

    @NotNull
    private String status;
}
