package com.youngman.mop.domain.schedule.dao;

import com.youngman.mop.domain.schedule.domain.Schedule;
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
