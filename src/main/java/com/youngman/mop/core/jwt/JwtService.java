package com.youngman.mop.core.jwt;

import com.google.common.collect.Maps;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Slf4j
@Component
public class JwtService {

    private static final String TYPE = "JWT";

    private static final String ALGORITHM = "HS256";

    private static final Long ABSOLUTE_EXPIRE_TIME = 1000L * 60 * 60 * 8;//8시간

    private static final String SECRET_KEY = "MoP";

    public String encode(String email, String name) {
        Map<String, Object> headerMap = Maps.newHashMap();
        headerMap.put("typ", TYPE);
        headerMap.put("alg", ALGORITHM);

        Map<String, Object> claimMap = Maps.newHashMap();
        claimMap.put("email", email);
        claimMap.put("name", name);

        Date now = new Date();

        JwtBuilder builder = Jwts.builder()
                .setHeader(headerMap)
                .setClaims(claimMap)
                .setExpiration(new Date(now.getTime() + ABSOLUTE_EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS256, generateKey());

        return builder.compact();
    }

    private Key generateKey() {
        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        return new SecretKeySpec(secretKeyBytes, SignatureAlgorithm.HS256.getJcaName());
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
        Map<String, Object> claimMap = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token)
                .getBody();

        return new Claim(claimMap);
    }

}
