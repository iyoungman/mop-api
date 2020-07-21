package com.youngman.mop.domain.myclub;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.domain.ClubRepository;
import com.youngman.mop.domain.member.domain.Member;
import com.youngman.mop.domain.member.domain.MemberRepository;
import com.youngman.mop.domain.myclub.api.dto.MyClubCreateRequest;
import com.youngman.mop.domain.myclub.domain.MyClubRepository;
import com.youngman.mop.domain.myclub.domain.MyClubValidator;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by iyoungman on 2020-07-21.
 */

@Transactional
@ExtendWith(MockitoExtension.class)
public class MyClubValidatorTest {

    @InjectMocks
    private MyClubValidator myClubValidator;

    @Mock
    private MyClubRepository myClubRepository;

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private ClubRepository clubRepository;

    private Long newMemberId = 1L;

    private Long registerMemberId = 2L;

    private Long clubId = 1L;

    @BeforeEach
    public void init() {
        lenient().when(memberRepository.findById(newMemberId)).thenReturn(Optional.of(new TestMember()));
        lenient().when(clubRepository.findById(clubId)).thenReturn(Optional.of(new TestClub()));
        lenient().when(myClubRepository.isExistMyClubByMemberIdAndClubId(newMemberId, clubId)).thenReturn(false);

        lenient().when(memberRepository.findById(registerMemberId)).thenReturn(Optional.of(new TestMember()));
        lenient().when(myClubRepository.isExistMyClubByMemberIdAndClubId(registerMemberId, clubId)).thenReturn(true);
    }

    @Test
    @DisplayName("가입되지 않은 멤버 정상 가입")
    public void validateMyClubAtNewMember() {
        MyClubCreateRequest request = MyClubCreateRequest.builder()
                .clubId(clubId)
                .memberId(newMemberId)
                .build();

        myClubValidator.validate(request.toEntity());
    }

    @Test
    @DisplayName("이미 가입된 멤버 가입 실패")
    public void validateMyClubAtRegisterMember() {
        MyClubCreateRequest request = MyClubCreateRequest.builder()
                .clubId(clubId)
                .memberId(registerMemberId)
                .build();

        assertThrows(IllegalArgumentException.class, () -> myClubValidator.validate(request.toEntity()));
    }

    static class TestMember extends Member {

    }

    static class TestClub extends Club {

    }
}
