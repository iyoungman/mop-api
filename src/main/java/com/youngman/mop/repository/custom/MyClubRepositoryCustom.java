package com.youngman.mop.repository.custom;

import com.youngman.mop.model.dto.MyClubResponseDto;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-23.
 */

public interface MyClubRepositoryCustom {

	List<MyClubResponseDto> fetchMyClubsByMemberEmail(String email);
}
