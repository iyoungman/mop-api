package com.youngman.mop.domain.myclub.domain;

import com.youngman.mop.domain.myclub.api.dto.MyClubResponse;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-23.
 */

public interface MyClubRepositoryCustom {

	boolean isExistMyClubByMemberIdAndClubId(Long memberId, Long clubId);
}
