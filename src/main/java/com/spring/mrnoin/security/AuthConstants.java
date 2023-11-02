package com.spring.mrnoin.security;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AuthConstants {
    public static final String AUTH_HEADER = "jwt-auth-token";
    public static final String REFRESH_HEADER = "jwt-ref-token";
    public static final String TOKEN_TYPE = "BEARER";
}
