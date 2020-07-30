package com.iyoungman.mop.api.domain.club.application.query;

import com.iyoungman.mop.api.domain.club.api.response.ClubInfoResponse;
import com.iyoungman.mop.api.domain.club.api.response.ClubPagingResponse;
import org.springframework.data.domain.PageRequest;

/**
 * Created by iyoungman on 2020-07-29.
 */

public interface ClubFindService {

    ClubPagingResponse selectPagingClubsByMember(Long memberId, PageRequest pageable);

    ClubInfoResponse selectClubInfoById(Long clubId);
}
