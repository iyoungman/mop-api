package com.youngman.mop.model.common;

/**
 * Created by YoungMan on 2019-05-27.
 */

public final class PageRequest {

	private int page;
	private int size;

	public void setPage(int page) {
		this.page = page <= 0 ? 1 : page;
	}

	public void setSize(int size) {
		int DEFAULT_SIZE = 24;
		int MAX_SIZE = 48;
		this.size = size > MAX_SIZE ? DEFAULT_SIZE : size;
	}

	public static org.springframework.data.domain.PageRequest of(int page, int size) {
		return org.springframework.data.domain.PageRequest.of(page - 1, size);
	}
}
