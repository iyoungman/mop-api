package com.iyoungman.mop.api.domain.member.domain;

import com.iyoungman.mop.api.common.model.Address;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by YoungMan on 2019-05-08.
 */

public interface MemberRepository extends JpaRepository<Member, Long> {

    Boolean existsByEmail(String email);

    Optional<Member> findByEmail(String email);

    void deleteByEmail(String email);

    @Query(value = "SELECT m.address FROM Member m WHERE m.id = :id")
    Optional<Address> findAddressById(Long id);

}
