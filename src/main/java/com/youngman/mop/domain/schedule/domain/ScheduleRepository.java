package com.youngman.mop.domain.schedule.domain;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by YoungMan on 2019-05-24.
 */

public interface ScheduleRepository extends JpaRepository<Schedule, Long>, ScheduleRepositoryCustom {

//    @Query("SELECT s.meetingTime FROM Schedule s WHERE s.clubId = :clubId AND s.meetingTime > :now")
//    Optional<LocalDateTime> findMeetingTimeByUpcoming(Long clubId, LocalDateTime now);
}
