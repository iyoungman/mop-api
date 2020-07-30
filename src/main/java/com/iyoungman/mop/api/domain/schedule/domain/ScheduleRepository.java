package com.iyoungman.mop.api.domain.schedule.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by YoungMan on 2019-05-24.
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {

    @Query("SELECT s.writer FROM Schedule s WHERE s.id = :scheduleId")
    String findByWriter(Long scheduleId);
}
