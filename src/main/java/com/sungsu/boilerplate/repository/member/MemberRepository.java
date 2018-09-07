package com.sungsu.boilerplate.repository.member;

import com.sungsu.boilerplate.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>{
}
