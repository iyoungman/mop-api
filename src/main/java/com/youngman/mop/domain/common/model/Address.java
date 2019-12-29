package com.youngman.mop.domain.common.model;

import lombok.AccessLevel;
import lombok.Builder;
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
public class Address {

	@Column(name = "city")
	private String city;

	@Column(name = "district")
	private String district;

	@Column(name = "neighborhood")
	private String neighborhood;

	@Builder
	public Address(String city, String district, String neighborhood) {
		this.city = city;
		this.district = district;
		this.neighborhood = neighborhood;
	}
}
