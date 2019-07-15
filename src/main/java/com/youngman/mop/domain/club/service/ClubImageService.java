package com.youngman.mop.domain.club.service;

import com.youngman.mop.domain.club.dao.ClubFindDao;
import com.youngman.mop.domain.club.dao.ClubRepository;
import com.youngman.mop.domain.club.domain.Club;
import com.youngman.mop.global.error.UserDefineException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by YoungMan on 2019-07-14.
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class ClubImageService {

	private final static String LINUX_PATH = "/home/ec2-user/project/target/mop-image/";
	private final static String WINDOW_PATH = "C:\\Users\\LG\\Desktop\\dwdw\\";

	private final ClubRepository clubRepository;
	private final ClubFindDao clubFindDao;


	public String uploadClubImage(Long clubId, MultipartFile imageFile) {
		Club club = clubFindDao.findById(clubId);
		String writePath = createFilePath(clubId);
		writeImageFile(writePath, imageFile);
		club.updateClubImagePath(writePath);
		clubRepository.save(club);

		return club.getClubImageUri();
	}

	private String createFilePath(Long clubId) {
		String fileName = clubId + "_" + "image.png";
		return WINDOW_PATH + fileName;
	}

	private void writeImageFile(String writePath, MultipartFile imageFile) {

		try {
			File file = new File(writePath);
			imageFile.transferTo(file);
		} catch (Exception e) {
			throw new UserDefineException(e.getMessage());
		}
	}
}
