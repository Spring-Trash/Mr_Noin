package com.spring.mrnoin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/tologinpage")
    public String loginForm(){
        return "log-in";
    }

    @RequestMapping("/tosignuppage")
    public String signUpForm(){
        return "sign-up";
    }

    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("member");
        return "index";
    }

    @RequestMapping("/tomypage")
    public String myPage(){
        return "mypage";
    }

}
