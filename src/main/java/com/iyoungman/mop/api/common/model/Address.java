package com.iyoungman.mop.api.common.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

	@Override
	public String toString() {
		return city + district + neighborhood;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Address address = (Address) o;
		return Objects.equals(city, address.city) &&
				Objects.equals(district, address.district) &&
				Objects.equals(neighborhood, address.neighborhood);
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, district, neighborhood);
	}
}
