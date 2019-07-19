package com.youngman.mop.domain.club.dao;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.club.dto.ClubResponse;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	Page<ClubResponse> fetchPagingClubsByMember(String email, String address, Pageable pageable);

	Optional<Club> fetchClubInfoById(Long clubId);
}
