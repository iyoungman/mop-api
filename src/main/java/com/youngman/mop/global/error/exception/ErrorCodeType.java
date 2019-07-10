package com.youngman.mop.global.error.exception;

import lombok.Getter;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Getter
public enum ErrorCodeType {

	//Common
	UNKNOWN(400, "COMMON_001", "UNKNOWN"),

	//Member
	EMAIL_DUPLICATION(400, "M001", "이메일이 중복됩니다"),
	MEMBER_NOT_FOUND(400, "M002", "회원을 찾을 수 없습니다"),
	PASSWORD_INVALID(400, "M003", "비밀번호가 올바르지 않습니다"),

	//Club
	CLUB_NOT_FOUND(400, "C001", "동호회를 찾을 수 없습니다"),

	//MyClub
	MYCLUB_ALREADY_EXIST(400, "MC001", "이미 추가한 동호회 입니다"),

	//Board
	BOARD_NOT_FOUND(400, "B001", "게시글을 찾을 수 없습니다"),

	//Schedule
	SCHEDULE_NOT_FOUND(400, "S001", "스케줄을 찾을 수 없습니다"),
	MEETING_TIME_INVALID(400, "S002", "만남 시간은 지금시간 이후여야 합니다"),

	//Board, Schedule
	WRITER_INVALID(400, "BS001", "작성자와 수정자가 올바르지 않습니다");


	private int status;
	private String code;
	private String message;


	ErrorCodeType(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
