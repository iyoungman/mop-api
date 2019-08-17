package com.youngman.mop.global.jwt;

import com.youngman.mop.global.error.UserDefineException;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by YoungMan on 2019-06-15.
 */

@Slf4j
@Service
public class JwtService {

    private final String SECRET_KEY = "MOP";
    private final long EXPIRE_TIME = 100000 * 60 * 60;


    public String createJwt(String email, String name) {
        Map<String, Object> claimMap = new HashMap<String, Object>();
        claimMap.put("EMAIL", email);
        claimMap.put("NAME", name);

        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + EXPIRE_TIME);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("issueDate", System.currentTimeMillis())
                .setClaims(claimMap)
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, generateKey())
                .compact();
    }

    public boolean isUsable(String jwt) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(generateKey())
                    .parseClaimsJws(jwt);
            return true;
        } catch (ExpiredJwtException e) {
            return false;
        }
    }

    public String findEmailByJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(jwt)
                .getBody();

        return (String) claims.get("EMAIL");
    }

    public String findNameByJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(jwt)
                .getBody();

        return (String) claims.get("NAME");
    }

    private byte[] generateKey() {
        try {
            return SECRET_KEY.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new UserDefineException("Secret Key 변환 실패");
        }
    }
}
