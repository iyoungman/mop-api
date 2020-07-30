package com.iyoungman.mop.api.core.jwt;

import com.google.common.collect.Maps;
import io.jsonwebtoken.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JwtService {

    private static final String TYPE = "JWT";

    private static final String ALGORITHM = "HS256";

    private static final long ABSOLUTE_EXPIRE_TIME = 1000 * 60 * 60 * 8;//8시간

    private static final String SECRET_KEY = "MoP";

    public String encode(Long id, String email, String name) {
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("typ", TYPE);
        headerMap.put("alg", ALGORITHM);

        Map<String, Object> claimMap = Maps.newHashMap();
        claimMap.put("id", id);
        claimMap.put("email", email);
        claimMap.put("name", name);

        Date expireTime = new Date();
        expireTime.setTime(expireTime.getTime() + ABSOLUTE_EXPIRE_TIME);

        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("issueDate", System.currentTimeMillis())
                .setClaims(claimMap)
                .setExpiration(expireTime)
                .signWith(SignatureAlgorithm.HS256, generateKey());

        return builder.compact();
    }

    public boolean isValidate(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException e) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException e) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException e) {
            log.error("Expired JWT token");
        } catch (IllegalArgumentException e) {
            log.error("Empty JWT claims");
        }
        return false;
    }

    public Claim decode(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(generateKey())
                .parseClaimsJws(token)
                .getBody();

        return new Claim(claims);
    }

    private byte[] generateKey() {
        return SECRET_KEY.getBytes(StandardCharsets.UTF_8);
    }

}
