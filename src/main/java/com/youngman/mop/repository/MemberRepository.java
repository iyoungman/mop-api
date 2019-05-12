package com.youngman.mop.repository;

import com.youngman.mop.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by YoungMan on 2019-05-08.
 */

public interface MemberRepository extends JpaRepository<Member,String> {

}
