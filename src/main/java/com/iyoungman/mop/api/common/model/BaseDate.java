package com.iyoungman.mop.api.common.model;

import java.time.LocalDate;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Created by YoungMan on 2019-06-18.
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDate {

	@CreatedDate
	private LocalDate createdDate;

	@LastModifiedDate
	private LocalDate modifiedDate;
}
