package com.yong.PlabFootball.global.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> {
            web.ignoring()
                    .anyRequest()
                    .requestMatchers("/api/members/**");
        };
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .headers(headerConfig ->
//                    headerConfig.frameOptions(
//                                HeadersConfigurer.FrameOptionsConfig::disable
//                            )
//                ).authorizeHttpRequests(authorizeRequests ->
//                    authorizeRequests.requestMatchers(PathRequest.toH2Console()).permitAll()
//                            .requestMatchers("/members/**","/api/members/**").permitAll()
//                );
//
//        return http.build();
//    }
}
