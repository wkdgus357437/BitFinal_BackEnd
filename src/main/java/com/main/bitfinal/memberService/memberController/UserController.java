package com.main.bitfinal.memberService.memberController;

import com.main.bitfinal.memberService.dto.ChangePasswordRequestDTO;
import com.main.bitfinal.memberService.dto.UserRequestDTO;
import com.main.bitfinal.memberService.dto.UserResponseDTO;
import com.main.bitfinal.memberService.memberEntity.MemberDTO;
import com.main.bitfinal.memberService.memberEntity.User;
import com.main.bitfinal.memberService.repository.UserRepository;
import com.main.bitfinal.memberService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor // 생성자 자동 생성 by 롬복 (autowired 필요없음)
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> getMyMemberInfo() {
        UserResponseDTO myInfoBySecurity = userService.getMyInfoBySecurity();
        System.out.println(myInfoBySecurity.getName());
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }

    @PostMapping("/nickname")
    public ResponseEntity<UserResponseDTO> setMemberNickname(@RequestBody UserRequestDTO request) {
        return ResponseEntity.ok(userService.changeUsername(request.getUsername(), request.getName()));
    }

    @PostMapping("/password")
    public ResponseEntity<UserResponseDTO> setMemberPassword(@RequestBody ChangePasswordRequestDTO request) {
        return ResponseEntity.ok(userService.changeMemberPassword(request.getExPwd(), request.getNewPwd()));
    }

    // 아이디 중복체크
    @GetMapping(path = "duplicationChk")
    public String duplicationChk(@RequestParam String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return "duplicate";
        } else {
            return null;
        }
    }


    // 이미 가입한 회원 체크 (회원가입 시 본인인증 후 이름 중복검사)
    @GetMapping(path = "existName")
    public String existName(@RequestParam String name) {
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()) {
            return "exist";
        } else {
            return null;
        }
    }

}

// ResponseEntity 구조 http://stanley-dev-log.tistory.com/7