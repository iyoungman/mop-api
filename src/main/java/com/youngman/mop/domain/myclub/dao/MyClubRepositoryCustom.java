package com.youngman.mop.domain.myclub.dao;

import com.youngman.mop.domain.myclub.dto.MyClubResponse;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-23.
 */

public interface MyClubRepositoryCustom {

	List<MyClubResponse> fetchMyClubsByMemberEmail(String email);
}
