package com.youngman.mop.global.error.exception;

import lombok.Getter;

/**
 * Created by YoungMan on 2019-06-17.
 */

@Getter
public enum ErrorCodeType {

	//Common
	UNKNOWN(400, "U000", "UNKNOWN"),

	//Member
	EMAIL_DUPLICATION(400, "M001", "Email Is Duplication"),
	MEMBER_NOT_FOUND(400, "M002", "Member Not Found"),
	PASSWORD_INVALID(400, "M003", "Password Is Invalid"),

	//Club
	CLUB_NOT_FOUND(400, "C001", "Club Not Found"),

	//MyClub

	//Board
	BOARD_NOT_FOUND(400, "B001", "Board Not Found"),
	WRITER_INVALID(400, "B002", "Writer Is Invalid"),

	//Schedule
	SCHEDULE_NOT_FOUND(400, "S001", "Schedule Not Found");


	private int status;
	private String code;
	private String message;


	ErrorCodeType(int status, String code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
