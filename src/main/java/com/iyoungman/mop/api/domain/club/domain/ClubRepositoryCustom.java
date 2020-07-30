package com.iyoungman.mop.api.domain.club.domain;

import com.iyoungman.mop.api.common.model.Address;
import com.iyoungman.mop.api.domain.club.api.response.ClubResponse;
import com.iyoungman.mop.api.domain.member.domain.Member;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	Page<ClubResponse> selectPagingClubsByMemberAddress(Address address, Pageable pageable);

	List<Member> selectClubMembers(Long clubId);
}
