package com.youngman.mop.repository;

import com.youngman.mop.domain.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-24.
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

}
