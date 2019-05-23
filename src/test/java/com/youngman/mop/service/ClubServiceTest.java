package com.youngman.mop.service;

import com.youngman.mop.repository.ClubRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

/**
 * Created by YoungMan on 2019-05-23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ClubServiceTest {

	@Autowired
	private ClubRepository clubRepository;

	
}
