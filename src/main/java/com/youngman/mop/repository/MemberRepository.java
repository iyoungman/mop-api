package com.youngman.mop.repository;

import com.youngman.mop.model.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by YoungMan on 2019-05-08.
 */

public interface MemberRepository extends JpaRepository<Member,Long> {

	Boolean existsByEmail(String email);

	Optional<Member> findByEmail(String email);
}
