package com.spring.mrnoin.security;

import com.spring.mrnoin.vo.AccountVO;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public final class TokenUtils {
    private static final String secretKey = "KimGyuHyun_LeeByungHeon";

    public static String generateJwtToken(AccountVO accountVO){
        JwtBuilder builder = Jwts.builder()
                .setSubject(accountVO.getId())
                .setHeader(createHeader())
                .setClaims(createClaim(accountVO))
                .setExpiration(createExpireDateForOneDay())
                .signWith(SignatureAlgorithm.HS256, createSigningKey());

        return builder.compact();
    }

    private static Map<String, Object> createHeader(){
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        header.put("regDate", System.currentTimeMillis());
        return header;
    }

    private static Map<String, Object> createClaim(AccountVO accountVO){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", accountVO.getId());
        claims.put("role", accountVO.getAuthorities().toString());
        return claims;
    }

    private static Date createExpireDateForOneDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    private static Key createSigningKey(){
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secretKey);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    private static Claims getClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
                .parseClaimsJws(token).getBody();
    }

    private static String getUserIdFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return (String) claims.get("id");
    }

    private static String getRoleFromToken(String token){
        Claims claims = getClaimsFromToken(token);
        return (String) claims.get("role");
    }

    public static String getTokenFromHeader(String header){
        return header.split(" ")[1];
    }

    public static boolean isValidToken(String token){
        try{
            Claims claims = getClaimsFromToken(token);
            log.info("id : {}", claims.get("id"));
            log.info("rold : {}", claims.get("role"));
            log.info("expireTime : {}", claims.getExpiration());
            return true;
        } catch (ExpiredJwtException exception){
            log.error("Token Expired");
            return false;
        } catch (JwtException exception){
            log.error("Token Tampered");
            return false;
        } catch(NullPointerException exception){
            log.error("Token is null");
            return false;
        }
    }
}
