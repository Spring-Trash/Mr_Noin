package com.spring.mrnoin.controller;

import com.spring.mrnoin.security.AccountService;
import com.spring.mrnoin.security.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User principal = (User) authentication.getPrincipal();

        String userName = principal.getUsername();

        AccountVO accountVO = accountService.getAcoountVOById(userName);
        model.addAttribute("account", accountVO);

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

    @RequestMapping("/noview")
    public String noview(){return "test"; }

}
