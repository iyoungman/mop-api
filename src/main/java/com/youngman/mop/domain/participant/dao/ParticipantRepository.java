package com.youngman.mop.domain.participant.dao;

import com.youngman.mop.domain.participant.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by YoungMan on 2019-07-25.
 */

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query("select p from Participant p where p.schedule.id = :scheduleId order by p.email asc")
    List<Participant> findBySchedule(@Param("scheduleId") Long scheduleId);

    @Query("select p from Participant p where p.email = :email and p.schedule.id = :scheduleId")
    Optional<Participant> findByEmailAndSchedule(@Param("email") String email,
                                                 @Param("scheduleId") Long scheduleId);
}
