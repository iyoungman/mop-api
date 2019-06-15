package com.youngman.mop.service.jwt;

import com.youngman.mop.exception.UserDefineException;
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
	private final long EXPIRE_TIME = 1000 * 60 * 60;


	public String createJwt(String email) {
		Map<String, Object> claimMap = new HashMap<String, Object>();
		claimMap.put("EMAIL", email);

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
			throw UserDefineException.builder()
					.message("사용기간이 만료되었습니다")
					.originalErrorMessage(e.getMessage())
					.build();
		}
	}

	public String findEmailByJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(generateKey())
				.parseClaimsJws(jwt)
				.getBody();

		return (String) claims.get("EMAIL");
	}

	private byte[] generateKey(){
		try {
			return SECRET_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new UserDefineException("Secret Key 변환 실패");
		}
	}
}
