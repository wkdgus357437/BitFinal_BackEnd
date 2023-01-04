package com.main.bitfinal.memberService.memberController;

import com.main.bitfinal.memberService.memberEntity.MemberDTO;
import com.main.bitfinal.memberService.memberEntity.User;
import com.main.bitfinal.memberService.repository.MemberRepository;
import com.main.bitfinal.memberService.repository.UserRepository;
import com.main.bitfinal.memberService.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/member123")
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder; // config 에서 @Bean 처리로 dependency Injection

    @PostMapping(path = "join")
    public void join(@ModelAttribute MemberDTO memberDTO) {
        memberDTO.setRole("ROLE_USER"); // 일반회원 기본
        String rawPassword = memberDTO.getPassword();
        String encPassword = passwordEncoder.encode(rawPassword); // 비밀번호 암호화
        memberDTO.setPassword(encPassword); // 암호화된 비밀번호로 입력
        memberRepository.save(memberDTO); // 회원가입 완료
        log.info("회원가입 성공");

    }

    @GetMapping(path = "duplicationChk")
    public String duplicationChk(@RequestParam String username) {
        Optional<MemberDTO> memberDTO = memberRepository.findByUsername(username);
        if (memberDTO.isPresent()) {
            return "duplicate";
        } else {
            return null;
        }
    }

    @GetMapping(path = "test")
    public List<User> getAlluser(){
        return userRepository.findAll();
    }
}
