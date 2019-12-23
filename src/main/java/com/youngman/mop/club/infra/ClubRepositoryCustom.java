package com.youngman.mop.club.infra;

import com.youngman.mop.club.command.domain.Club;
import com.youngman.mop.club.command.dto.ClubResponse;
import com.youngman.mop.member.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	Page<ClubResponse> selectPagingClubsByMember(String email, String address, Pageable pageable);

	Optional<Club> selectClubInfoById(Long clubId);

	List<Member> selectClubMembers(Long clubId);
}