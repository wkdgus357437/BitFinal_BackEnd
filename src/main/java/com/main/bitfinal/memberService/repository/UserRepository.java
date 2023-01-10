package com.main.bitfinal.memberService.repository;

import com.main.bitfinal.memberService.dto.UserResponseDTO;
import com.main.bitfinal.memberService.memberEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username); // user 조회

    boolean existsByUsername(String username); // duplication chk

    Optional<User> findByName(String name);

    void deleteByUsername(String username);

}
