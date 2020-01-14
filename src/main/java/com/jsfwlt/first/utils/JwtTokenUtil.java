package com.jsfwlt.first.utils;

import com.jsfwlt.first.dto.jwt.CheckResult;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;



/**
 * @author 十方飞鱼
 * @date 2020/1/13 15:44
 */
@Component
public class JwtTokenUtil {
    /**
     * 签发JWT
     * @param id
     * @param subject 可以是JSON数据 尽可能少
     * @param ttlMillis
     * @return  String
     *
     */
    public static String createJWT(String id, String subject, long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuer("user")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date expDate = new Date(expMillis);
            builder.setExpiration(expDate);
        }
        return builder.compact();
    }
    /**
     * 验证JWT
     * @param jwtStr
     * @return
     */
    public static CheckResult validateJWT(String jwtStr) {
        CheckResult checkResult = new CheckResult();
        Claims claims = null;
        try {
            claims = parseJWT(jwtStr);
            checkResult.setSuccess(true);
            checkResult.setClaims(claims);
        } catch (ExpiredJwtException e) {
            checkResult.setErrorCode("JWT_ERRORCODE_EXPIRE");
            checkResult.setSuccess(false);
        } catch (SignatureException e) {
            checkResult.setErrorCode("JWT_ERRORCODE_FAIL");
            checkResult.setSuccess(false);
        } catch (Exception e) {
            checkResult.setErrorCode("JWT_ERRORCODE_FAIL");
            checkResult.setSuccess(false);
        }
        return checkResult;
    }
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode("jsfwltkeyatk");
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     *
     * 解析JWT字符串
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        Claims claims = null;
        try {
             claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();
        }catch (ExpiredJwtException e){
            System.out.println("token超期");
            claims = e.getClaims();
        }
        return claims;
    }
}
