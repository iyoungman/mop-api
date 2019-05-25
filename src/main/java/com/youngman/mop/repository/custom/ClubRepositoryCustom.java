package com.youngman.mop.repository.custom;

import com.youngman.mop.model.dto.MyClubResponseDto;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	List<MyClubResponseDto> fetchPagingClubsByMember(String email, String address, int pageNo);
}
