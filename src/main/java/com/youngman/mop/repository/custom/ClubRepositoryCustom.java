package com.youngman.mop.repository.custom;

import com.youngman.mop.domain.entity.Club;
import com.youngman.mop.domain.dto.MyClubResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	Page<MyClubResponseDto> fetchPagingClubsByMember(String email, String address, Pageable pageable);

	Optional<Club> fetchClubInfoById(Long clubId);
}
