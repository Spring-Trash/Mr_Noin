package com.spring.mrnoin.security;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {

    private String authority = "ROLE_USER";
    @Override
    public String getAuthority() {
        return authority;
    }
}
