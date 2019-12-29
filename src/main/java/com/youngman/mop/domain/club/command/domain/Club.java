package com.youngman.mop.domain.club.command.domain;

import com.youngman.mop.domain.common.model.Address;
import com.youngman.mop.domain.common.model.BaseDate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

	@ElementCollection
	@CollectionTable(name = "club_member", joinColumns = @JoinColumn(name = "club_id"))
	private Set<Long> memberIds = new HashSet<>();

	//Hobby를 별도의 Entity로 빼자
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

	public void verifyChairMan(Long memberId) {
		if (!clubChair.getChairManId().equals(memberId)) {
			throw new RuntimeException();
		}
	}

	public void registerClub(Long memberId) {
		if (memberIds.contains(memberId)) {
			throw new RuntimeException("이미 동호회에 가입된 인원입니다.");
		}
		memberIds.add(memberId);
//		Events.Raise();
	}
}
