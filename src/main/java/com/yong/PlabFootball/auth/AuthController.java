package com.yong.PlabFootball.auth;


import com.yong.PlabFootball.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody SignUpMemberRequest signUpMemberRequest) {
        MemberDto member = authService.registerMember(signUpMemberRequest);
        return new ResponseEntity<>("signup success", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginMemberRequest loginMemberRequest) {
        MemberDto memberDto = authService.login(loginMemberRequest);
        return ResponseEntity.ok("success");
    }
}
