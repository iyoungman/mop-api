package com.iyoungman.mop.api.domain.member.api;

import com.iyoungman.mop.api.domain.member.api.dto.MemberCreateRequest;
import com.iyoungman.mop.api.domain.member.api.dto.MemberSignInRequest;
import com.iyoungman.mop.api.domain.member.api.dto.MemberSignInResponse;
import com.iyoungman.mop.api.domain.member.application.MemberCreateService;
import com.iyoungman.mop.api.domain.member.application.MemberDeleteService;
import com.iyoungman.mop.api.domain.member.application.MemberSignInService;
import com.iyoungman.mop.api.domain.member.application.MemberUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by YoungMan on 2019-05-24.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/mop/member")
public class MemberController {

    private final MemberSignInService memberSignInService;
    private final MemberCreateService memberCreateService;
    private final MemberUpdateService memberUpdateService;
    private final MemberDeleteService memberDeleteService;


    @PostMapping("/signin")
    public MemberSignInResponse signInMember(@RequestBody MemberSignInRequest memberSignInRequest) {
        return memberSignInService.singInMember(memberSignInRequest);
    }

    @PostMapping("/signup")
    public void createMember(@RequestBody MemberCreateRequest memberCreateRequest) {
        memberCreateService.createMember(memberCreateRequest);
    }

    @PutMapping
    public void updateMember(@RequestBody MemberCreateRequest memberCreateRequest,
                             @RequestHeader("token") String token) {
        memberUpdateService.updateMember(memberCreateRequest);
    }

    @DeleteMapping
    public void deleteMember(@RequestParam("email") String email) {
        memberDeleteService.deleteByEmail(email);
    }
}
