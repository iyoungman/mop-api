package com.youngman.mop.member.domain;

import com.youngman.mop.domain.generic.time.BaseDate;
import com.youngman.mop.myclub.domain.MyClub;
import com.youngman.mop.domain.myhobby.domain.MyHobby;
import com.youngman.mop.member.controller.MemberCreateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "member_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseDate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(unique = true)
    private String email;

    private String pw;

    private String name;

    private String mobile;

    private String address;

    private String introduce;

    private String fcmToken;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MyClub> myClubs = new ArrayList<>();

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MyHobby> myHobbies = new ArrayList<>();

    @Builder
    public Member(String email, String pw, String name, String mobile,
                  String address, String introduce, String fcmToken) {
        this.email = email;
        this.pw = pw;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.introduce = introduce;
        this.fcmToken = fcmToken;
    }

    public static Member of(MemberCreateRequest memberCreateRequest) {
        return Member.builder()
                .email(memberCreateRequest.getEmail())
                .pw(memberCreateRequest.getPw())
                .name(memberCreateRequest.getName())
                .mobile(memberCreateRequest.getMobile())
                .address(memberCreateRequest.getAddress())
                .fcmToken(memberCreateRequest.getFcmToken())
                .build();
    }

    public void updateMember(MemberCreateRequest memberCreateRequest) {
        this.pw = memberCreateRequest.getPw();
        this.name = memberCreateRequest.getName();
        this.mobile = memberCreateRequest.getMobile();
        this.address = memberCreateRequest.getAddress();
    }

}
