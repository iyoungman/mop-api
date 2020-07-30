package com.iyoungman.mop.api.domain.myclub.domain;

/**
 * Created by YoungMan on 2019-05-23.
 */

public interface MyClubRepositoryCustom {

	boolean isExistMyClubByMemberIdAndClubId(Long memberId, Long clubId);
}
