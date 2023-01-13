package com.main.bitfinal.memberService.service;

import com.main.bitfinal.memberService.dto.TokenDTO;
import com.main.bitfinal.memberService.dto.UserRequestDTO;
import com.main.bitfinal.memberService.dto.UserResponseDTO;
import com.main.bitfinal.memberService.jwt.TokenProvider;
import com.main.bitfinal.memberService.memberEntity.TokenRequestDTO;
import com.main.bitfinal.memberService.memberEntity.User;
import com.main.bitfinal.memberService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final AuthenticationManagerBuilder managerBuilder;
    private final TokenProvider tokenProvider;

    // 로그인 메소드
    // userRequestDto 에 있는 메소드 toAuthentication 를 통해 생긴
    // UsernamePasswordAuthenticationToken 타입의 데이터를 가지게된다.
    // 주입받은 Builder 를 통해 AuthenticationManager 를 구현한 ProviderManager 를 생성한다.
    // 이후 ProviderManager 는 데이터를 AbstractUserDetailsAuthenticationProvider 의 자식 클래스인
    // DaoAuthenticationProvider 를 주입받아서 호출한다.
    // DaoAuthenticationProvider 내부에 있는 authenticate 에서 retrieveUser 를 통해
    // DB 에서의 User 의 비밀번호가 실제 비밀번호가 맞는지 비교한다.
    // retrieveUser 에서는 DB 에서의 User 를 꺼내기 위해,
    // CustomUserDetailService 에 있는 loadUserByUsername 을 가져와 사용한다.
    // 여기서 CustomUserDetailsService 에서 오버라이딩한 loadUserByUsername 이 사용된다.

    public TokenDTO login(UserRequestDTO requestDTO) {
        UsernamePasswordAuthenticationToken authenticationToken = requestDTO.toAuthentication();

        Authentication authentication = managerBuilder.getObject().authenticate(authenticationToken);
        return tokenProvider.generateTokenDto(authentication);

    }

    public TokenDTO reIssue(TokenRequestDTO tokenRequestDTO) {

        // 서버에서 넘어온 리프레시 토큰 비교
        if (!tokenProvider.validateToken(tokenRequestDTO.getRefreshToken())) {
            throw new RuntimeException("refreshToken 이 유효하지 않습니다.");
        }

        // 일치하면 새로운 토큰 발급 후 쿠키와 리덕스에 새로운 토큰 저장
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDTO.getAccessToken());

        System.out.println("페이지새로고침-토큰재발급");

        return tokenProvider.generateTokenDto(authentication);
    }
}
