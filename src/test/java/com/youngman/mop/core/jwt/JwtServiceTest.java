package com.youngman.mop.core.jwt;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by YoungMan on 2019-06-15.
 */

@SpringBootTest
public class JwtServiceTest {

    @Autowired
    private JwtService jwtService;

    private final String email = "testEmail";
    private final String name = "testName";
    private String jwt;

    @BeforeEach
    public void createJwt() {
        jwt = jwtService.encode(email, name);
    }

    @Test
    @DisplayName("성공하는 토큰")
    public void findEmailAndNameBySuccessToken() {
        Claim claim = jwtService.decode(jwt);

        assertEquals(email, claim.getEmail());
        assertEquals(name, claim.getName());
    }

    @Test
    @DisplayName("실패하는 토큰")
    public void findEmailAndNameByFailedToken() {
        String invalidEmail = "invalidEmail";
        String invalidName = "invalidName";

        Claim claim = jwtService.decode(jwt);

        assertNotEquals(invalidEmail, claim.getEmail());
        assertNotEquals(invalidName, claim.getName());
    }
}
