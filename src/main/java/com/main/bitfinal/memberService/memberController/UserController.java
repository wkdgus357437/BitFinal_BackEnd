package com.main.bitfinal.memberService.memberController;

import com.main.bitfinal.memberService.dto.ChangePasswordRequestDTO;
import com.main.bitfinal.memberService.dto.UserRequestDTO;
import com.main.bitfinal.memberService.dto.UserResponseDTO;
import com.main.bitfinal.memberService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:3000")
@RestController
@RequiredArgsConstructor // 생성자 자동 생성 by 롬복 (autowired 필요없음)
@RequestMapping("/member")
public class UserController {

    private final UserService userService;

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

    @GetMapping(path = "delete")
    public void deleteUser(@RequestParam String username) {
        System.out.println(username);
        userService.deleteByUsername(username);
    }
}
