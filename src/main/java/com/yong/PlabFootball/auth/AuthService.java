package com.yong.PlabFootball.auth;

import com.yong.PlabFootball.member.dto.MemberDto;
import com.yong.PlabFootball.member.service.SearchMemberService;
import com.yong.PlabFootball.member.service.SignUpMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {

    private final JwtProvider jwtProvider;
    private final SignUpMemberService signUpMemberService;
    private final SearchMemberService searchMemberService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberDto registerMember(RegisterMember registerMember) {
        MemberDto registerDto = MemberDto.builder()
                .name(registerMember.getName())
                .email(registerMember.getEmail())
                .password(passwordEncoder.encode(registerMember.getPassword()))
                .build();

        MemberDto signUpMember = signUpMemberService.signUpMember(registerDto);
        System.out.println("save ok");

        return signUpMember;
    }

    public MemberDto login(LoginMember loginMember) {
        MemberDto loginDto = MemberDto.builder()
                .email(loginMember.getEmail())
                .password(loginMember.getPassword())
                .build();

        MemberDto memberDto = searchMemberService.searchMemberByEmail(loginDto);

//        checkLoginPassword(memberDto, loginMember);

        return null;
    }
}
