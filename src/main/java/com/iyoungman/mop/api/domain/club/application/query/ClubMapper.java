package com.iyoungman.mop.api.domain.club.application.query;

import com.iyoungman.mop.api.domain.club.api.response.ClubInfoResponse.ClubInfo;
import com.iyoungman.mop.api.domain.club.api.response.ClubInfoResponse.MemberInfo;
import com.iyoungman.mop.api.domain.club.domain.Club;
import com.iyoungman.mop.api.domain.member.domain.Member;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

/**
 * Created by iyoungman on 2020-07-30.
 */

@Component
public class ClubMapper {

    public ClubInfo convertToClubInfo(Club club) {
        return ClubInfo.builder()
                .clubId(club.getId())
                .createDate(club.getCreatedDate())
                .name(club.getName())
                .introduce(club.getIntroduce())
                .imageUri(club.getImagePath())
                .build();
    }

    public List<MemberInfo> convertToMemberInfos(List<Member> members) {
        return members.stream()
                .map(m -> {
                    return MemberInfo.builder()
                            .memberId(m.getId())
                            .email(m.getEmail())
                            .name(m.getName())
                            .introduce(m.getIntroduce())
                            .mobile(m.getMobile())
                            .build();
                })
                .collect(Collectors.toList());
    }


}
