package com.youngman.mop.domain.schedule.dao;

import com.youngman.mop.domain.schedule.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {

    @Query("SELECT s FROM Schedule s WHERE s.club.id = :clubId AND s.meetingTime > :now ORDER BY s.meetingTime ASC")
    List<Schedule> findUpComingByNow(@Param("clubId") Long clubId, @Param("now") LocalDateTime now);
}
