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
    public MemberDto registerMember(SignUpMemberRequest signUpMemberRequest) {
        return signUpMemberService.signUpMember(signUpMemberRequest.toMemberDto());
    }

    public MemberDto login(LoginMemberRequest loginMemberRequest) {
        MemberDto memberDto = searchMemberService.searchMemberByEmail(loginMemberRequest.toMemberDto());
        matchLoginPassword(memberDto, loginMemberRequest);
        return memberDto;
    }

    private void matchLoginPassword(MemberDto memberDto, LoginMemberRequest loginMemberRequest) {
        if (!passwordEncoder.matches(loginMemberRequest.getPassword(), memberDto.getPassword()))
            throw new RuntimeException();
    }
}
