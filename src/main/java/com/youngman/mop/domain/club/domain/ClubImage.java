package com.youngman.mop.domain.club.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubImage {

	@Column(name = "image_path")
	private String imagePath;

	public ClubImage(String imagePath) {
		this.imagePath = imagePath;
	}
}
