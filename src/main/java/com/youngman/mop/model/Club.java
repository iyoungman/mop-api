package com.youngman.mop.model;

import com.youngman.mop.model.dto.ClubCreateRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-08.
 */

@Entity
@Table(name = "club_tbl")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Club {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "club_id")
	private Long id;

	private String name;

	private String introduce;

	private String region;

	private String hobby;

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;

	//여기 있어야 할게 아니다 - 일정이 가지는게 맞을것 같다
//	private String upComingMeeting;

//	private String upComingMeetingDate;

	@OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
	private List<MyClub> myClubs = new ArrayList<>();

	@Builder
	public Club(String name, String introduce, String region, String hobby, List<MyClub> myClubs) {
		this.name = name;
		this.introduce = introduce;
		this.region = region;
		this.hobby = hobby;
		this.myClubs = myClubs;
	}

	public static Club of(ClubCreateRequestDto clubCreateRequestDto) {
		return Club.builder()
				.name(clubCreateRequestDto.getName())
				.introduce(clubCreateRequestDto.getIntroduce())
				.region(clubCreateRequestDto.getRegion())
				.hobby(clubCreateRequestDto.getHobby())
				.build()
		;
	}

	//Update


}
