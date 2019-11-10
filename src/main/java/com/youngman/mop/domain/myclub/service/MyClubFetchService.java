package com.youngman.mop.domain.myclub.service;

import com.youngman.mop.domain.myclub.dao.MyClubRepository;
import com.youngman.mop.domain.myclub.dto.MyClubResponse;
import com.youngman.mop.domain.schedule.dao.ScheduleFindDao;
import com.youngman.mop.domain.schedule.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-24.
 */

@Service
@RequiredArgsConstructor
public class MyClubFetchService {

    private final MyClubRepository myClubRepository;
    private final ScheduleFindDao scheduleFindDao;

    public List<MyClubResponse> fetchMyClubsByMemberEmail(String email) {
        List<MyClubResponse> myClubResponses = myClubRepository.fetchMyClubsByMemberEmail(email);
        for (MyClubResponse myClub : myClubResponses) {
            Schedule schedule = scheduleFindDao.findUpComingByNow(myClub.getClubId());
            if (schedule != null) {
                myClub.setUpComingMeetingDate(schedule.getMeetingTime());
            }
        }

        return myClubResponses;
    }
}
