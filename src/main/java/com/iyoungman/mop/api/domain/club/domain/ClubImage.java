package com.iyoungman.mop.api.domain.club.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Created by YoungMan on 2019-12-23.
 */

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClubImage {

	@Column(name = "image_path")
	private String imagePath;

	ClubImage(String imagePath) {
		this.imagePath = imagePath;
	}

	String getImagePath() {
		return imagePath;
	}

	@Override
	public String toString() {
		return imagePath;
	}
}
