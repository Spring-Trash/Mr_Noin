package com.spring.mrnoin.config;


import com.spring.mrnoin.filter.AuthenticationFilter;
import com.spring.mrnoin.filter.AuthenticationProvider;
import com.spring.mrnoin.handler.LoginFailureHandler;
import com.spring.mrnoin.handler.LoginSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig{

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        log.info("SecurityConfig : filterChain");

        // 로그인, 회원가입 페이지 인가
        // 정적자원 인가
        httpSecurity.authorizeRequests().antMatchers("/tologinpage", "/tosignuppage", "/status", "/iddupcheck", "/register").permitAll();
        httpSecurity.authorizeRequests().antMatchers("/resources/**").permitAll();
        httpSecurity.authorizeRequests().anyRequest().authenticated();

        // 추후 메인페이지 추가하면 자원 인가해야한다.

        // 사이트 위변조 방지
        httpSecurity.csrf().disable();

        // 로그인 설정 및 로그인 시도시 필터 등록
        httpSecurity.formLogin()
                .loginPage("/tologinpage").loginProcessingUrl("/tologinpage")
                .usernameParameter("id").passwordParameter("password")
                .defaultSuccessUrl("/").failureUrl("/tologinpage")
                .and().addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        // 로그아웃 설정
        httpSecurity.logout()
                .invalidateHttpSession(true).logoutUrl("/logout")
                .logoutSuccessUrl("/tologinpage").deleteCookies("JSESSIONID", "remember-me");

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider());
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        return new AuthenticationProvider();
    }

    // 필터처리
    // 만든 필터 /login 접근시 적용
    // loginsuccesshandler적용

    @Bean
    public AuthenticationFilter authenticationFilter() throws Exception{
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(authenticationManager(), passwordEncoder());
        authenticationFilter.setFilterProcessesUrl("/loginconfirm");
        authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
        authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
        authenticationFilter.afterPropertiesSet();
        return authenticationFilter;
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new LoginSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {return new LoginFailureHandler();}

}
