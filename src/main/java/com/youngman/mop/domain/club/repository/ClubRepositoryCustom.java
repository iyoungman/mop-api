package com.youngman.mop.domain.club.repository;

import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	Page<MyClubResponse> fetchPagingClubsByMember(String email, String address, Pageable pageable);

	Optional<Club> fetchClubInfoById(Long clubId);
}
