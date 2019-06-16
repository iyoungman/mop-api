package com.youngman.mop.domain.review.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by YoungMan on 2019-05-23.
 */

@Entity
@Table(name = "review_tbl")
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Long id;

	@Lob
	private String content;

	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;

}
