package com.youngman.mop.domain.schedule.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ScheduleRepositoryCustom {

	List<Schedule> fetchSchedulesByClubIdAndMonthly(Long clubId, LocalDate date);

	Optional<LocalDateTime> findMeetingTimeByUpcoming(Long clubId);
}
