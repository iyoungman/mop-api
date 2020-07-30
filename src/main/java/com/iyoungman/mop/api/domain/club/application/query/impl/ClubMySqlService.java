package com.iyoungman.mop.api.domain.club.application.query.impl;

import com.iyoungman.mop.api.common.model.Address;
import com.iyoungman.mop.api.domain.club.api.response.ClubInfoResponse;
import com.iyoungman.mop.api.domain.club.api.response.ClubPagingResponse;
import com.iyoungman.mop.api.domain.club.api.response.ClubResponse;
import com.iyoungman.mop.api.domain.club.application.query.ClubFindService;
import com.iyoungman.mop.api.domain.club.application.query.ClubMapper;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.club.domain.ClubRepository;
import com.iyoungman.mop.api.domain.club.exception.ClubNotFoundException;
import com.iyoungman.mop.api.domain.member.domain.Member;
import com.iyoungman.mop.api.domain.member.domain.MemberRepository;
import com.iyoungman.mop.api.domain.myclub.domain.MyClubRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ClubMySqlService implements ClubFindService {

    private final ClubRepository clubRepository;

    private final MemberRepository memberRepository;

    private final MyClubRepository myClubRepository;

    private final ClubMapper clubMapper;

    public ClubPagingResponse selectPagingClubsByMember(Long memberId, PageRequest pageable) {
        Address address = memberRepository.findAddressById(memberId).orElseThrow(() -> new RuntimeException());

        Page<ClubResponse> pagingClubResponse = clubRepository.selectPagingClubsByMemberAddress(address, pageable);
        return ClubPagingResponse.of(pagingClubResponse);
    }

    public ClubInfoResponse selectClubInfoById(Long clubId) {
        //동호회 조회
        Club club = clubRepository.findById(clubId).orElseThrow(ClubNotFoundException::new);

        //가입 멤버Id 조회
        List<Long> memberIds = myClubRepository.findMemberIdsByClubId(clubId);

        //멤버 조회
        List<Member> members = memberRepository.findAllById(memberIds);

        return new ClubInfoResponse(clubMapper.convertToClubInfo(club), clubMapper.convertToMemberInfos(members));
    }

}