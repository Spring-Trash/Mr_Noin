package com.spring.mrnoin.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.servlet.DispatcherType;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable().cors().disable()
                // csrf, cors disable
                // 모든 요청에 대해 인증
                // 회원가입은 예외로
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                        .antMatchers("/tosignuppage", "/status", "/iddupcheck", "/register").permitAll()
                        .anyRequest().authenticated()
                )
                // 인증 없으면 보내버릴 기본 로그인 페이지
                // submit받는 url, 파라미터 등록
                // id, pw는 jsp name과 같이
                .formLogin(login -> login
                        .loginPage("/tologinpage")
                        .loginProcessingUrl("/loginconfirm")
                        .usernameParameter("id")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(withDefaults());
        return httpSecurity.build();
    }

}
