package com.main.bitfinal.memberService.repository;

import com.main.bitfinal.memberService.memberEntity.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 기본적인 CRUD 함수를 JpaRepository가 가지고있다.
// @Repository 어노테이션이 없어도 Ioc 된다.(JpaRepository를 상속했기때문)
public interface MemberRepository extends JpaRepository<MemberDTO, String> {

    Optional<MemberDTO> findByUsername(String username);
}
