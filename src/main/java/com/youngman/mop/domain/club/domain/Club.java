package com.youngman.mop.domain.club.domain;

import com.youngman.mop.common.model.Address;
import com.youngman.mop.common.model.BaseDate;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "club_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club extends BaseDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "club_id")
    private Long id;

    private String name;

    private String introduce;

    @Embedded
    private Address address;

    @Embedded
    private ClubChair clubChair;

    @Embedded
    private ClubImage clubImage;

    //TODO Hobby를 별도의 Entity로 빼자
//    private List<Hobby> hobby = new ArrayList<>();

    @Builder
    public Club(String name, String introduce, Address address,
            ClubChair clubChair, ClubImage clubImage) {
        this.name = name;
        this.introduce = introduce;
        this.address = address;
        this.clubChair = clubChair;
        this.clubImage = clubImage;
    }

    public void validate(ClubValidator clubValidator) {
        clubValidator.validate(this);
    }

    public void verifyChairMan(Long memberId) {
        if (!clubChair.getChairManId().equals(memberId)) {
            throw new RuntimeException();
        }
    }

    public void updateClubImagePath(String path) {
        this.clubImage = new ClubImage(path);
    }

    public String getImagePath() {
        return clubImage.getImagePath();
    }
}
