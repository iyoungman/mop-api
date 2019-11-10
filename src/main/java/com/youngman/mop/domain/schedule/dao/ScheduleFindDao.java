package com.youngman.mop.domain.schedule.dao;

import com.youngman.mop.domain.schedule.domain.Schedule;
import com.youngman.mop.domain.schedule.exception.ScheduleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by YoungMan on 2019-06-20.
 */

@Service
@RequiredArgsConstructor
public class ScheduleFindDao {

    private final ScheduleRepository scheduleRepository;

    public Schedule findById(Long id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        schedule.orElseThrow(ScheduleNotFoundException::new);
        return schedule.get();
    }

    public String findWriterById(Long id) {
        Optional<Schedule> schedule = scheduleRepository.findById(id);
        schedule.orElseThrow(ScheduleNotFoundException::new);
        return schedule.get().getWriter();
    }

    public Schedule findUpComingByNow(Long clubId) {
        List<Schedule> schedules = scheduleRepository.findUpComingByNow(clubId, LocalDateTime.now());
        if (schedules.size() == 0 || schedules == null) {
            return null;
        }
        return schedules.get(0);
    }
}
