package com.youngman.mop.repository.custom;

import com.youngman.mop.model.dto.MyClubResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by YoungMan on 2019-05-25.
 */

public interface ClubRepositoryCustom {

	List<MyClubResponseDto> fetchPagingClubsByMember(String email, String address, int pageNo);

	Page<MyClubResponseDto> ff(String email, String address, Pageable pageable);
}
