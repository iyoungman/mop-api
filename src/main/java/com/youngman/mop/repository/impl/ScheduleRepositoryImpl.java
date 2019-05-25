package com.youngman.mop.repository.impl;

import com.youngman.mop.model.domain.Schedule;
import com.youngman.mop.repository.custom.ScheduleRepositoryCustom;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by YoungMan on 2019-05-25.
 */

public class ScheduleRepositoryImpl extends QuerydslRepositorySupport implements ScheduleRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	public ScheduleRepositoryImpl() {
		super(Schedule.class);
	}


}
