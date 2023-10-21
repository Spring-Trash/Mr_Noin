package com.spring.mrnoin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberLoginVO {
    @NotNull
    @NotBlank(message = "id는 4자 이상 20자 이하입니다.")
    @Size(message = "id는 4자 이상 20자 이하입니다.")
    private String id;

    // TODO : password 정규표현식 검사
    @NotNull
    @NotBlank(message = "password는 8자 이상 20자 이하입니다.")
    @Size(message = "password는 8자 이상 20자 이하입니다.")
    private String password;
}
