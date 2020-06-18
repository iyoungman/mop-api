package com.youngman.mop.domain.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by YoungMan on 2019-05-08.
 */

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByEmail(String email);

    Optional<Member> findByEmail(String email);

    void deleteByEmail(String email);

    @Query(value = "SELECT member.address FROM Member member WHERE member.email = :email")
    String findAddressByEmail(@Param("email") String email);

}
