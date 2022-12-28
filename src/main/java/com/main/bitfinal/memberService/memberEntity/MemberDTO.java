package com.main.bitfinal.memberService.memberEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "member")
public class MemberDTO {

    @Id
    @Column(name = "username", nullable = false, unique = true, length = 30)
    private String username; // hong
    private String name; // 아무개
    private String password; // 영문 + 숫자 조합
    private String role; // 기본 ROLE_USER
    private String email; // 유효성검증
    private String birth;
    private String phoneNumber;
    @CreationTimestamp
    private Timestamp createDate;

}
