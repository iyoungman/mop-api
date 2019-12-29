package com.youngman.mop.domain.participant;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Entity
@Table(name = "participant_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "participant_id")
	private Long id;

	private Long scheduleId;

	private Long memberId;

}
