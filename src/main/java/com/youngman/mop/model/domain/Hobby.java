package com.youngman.mop.model.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Entity
@Table(name = "hobby_tbl")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hobby {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hobby_id")
	private Long id;

	private String category;

	private String subCategory;

	@OneToMany(mappedBy = "hobby", fetch = FetchType.LAZY)
	private List<MyHobby> myHobbies = new ArrayList<>();
}
