package com.youngman.mop.model.domain;

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

	@OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
	private List<MyClub> myClubs = new ArrayList<>();

	@OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
	private List<Schedule> schedule = new ArrayList<>();

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

	public void updateClub(ClubCreateRequestDto clubCreateRequestDto) {
		this.name = clubCreateRequestDto.getName();
		this.introduce = clubCreateRequestDto.getIntroduce();
		this.region = clubCreateRequestDto.getRegion();
		this.hobby = clubCreateRequestDto.getHobby();
	}

}
