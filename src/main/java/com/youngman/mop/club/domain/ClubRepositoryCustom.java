package com.youngman.mop.club.domain;

import com.youngman.mop.club.controller.ClubResponse;
import com.youngman.mop.member.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

    Page<ClubResponse> fetchPagingClubsByMember(String email, String address, Pageable pageable);

    Optional<Club> fetchClubInfoById(Long clubId);

    List<Member> fetchClubMembers(Long clubId);
}
