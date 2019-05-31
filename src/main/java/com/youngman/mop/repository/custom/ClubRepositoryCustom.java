package com.youngman.mop.repository.custom;

import com.youngman.mop.model.domain.Club;
import com.youngman.mop.model.dto.MyClubResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	Page<MyClubResponseDto> fetchPagingClubsByMember(String email, String address, Pageable pageable);

	Club fetchClubInfoById(Long clubId);
}
