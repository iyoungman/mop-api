package com.youngman.mop.domain.member.api;

import com.youngman.mop.domain.member.application.MemberCreateService;
import com.youngman.mop.domain.member.application.MemberDeleteService;
import com.youngman.mop.domain.member.application.MemberSignInService;
import com.youngman.mop.domain.member.application.MemberUpdateService;
import com.youngman.mop.domain.member.dto.MemberCreateRequest;
import com.youngman.mop.domain.member.dto.MemberSignInRequest;
import com.youngman.mop.domain.member.dto.MemberSignInResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
