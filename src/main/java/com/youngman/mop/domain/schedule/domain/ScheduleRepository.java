package com.youngman.mop.domain.schedule.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-24.
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {

}
