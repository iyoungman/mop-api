package com.youngman.mop.global.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2019-07-10.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/auth/check")
public class JwtApi {

    private final JwtService jwtService;


    @GetMapping
    public boolean isValidToken(@RequestHeader("token") String token) {
        return jwtService.isUsable(token);
    }
}
