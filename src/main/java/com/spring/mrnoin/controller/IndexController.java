package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/")
    public String home(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.getPrincipal().equals("anonymousUser")) {
            AccountVO accountVO = accountService.getAccountVOById(authentication.getName());
            if(accountVO != null) {
                model.addAttribute("account", accountVO);
            }
        }

        return "index";
    }

    @RequestMapping("/tologinpage")
    public String loginForm(HttpServletRequest httpServletRequest, Model model){
        String msg = httpServletRequest.getParameter("msg");
        if(!(msg == null) && !(msg.equals(""))) model.addAttribute("msg", msg);
        System.out.println("tologinpage-----------------------------");
        return "account/log-in";
    }

    @RequestMapping("/tosignuppage")
    public String signUpForm(){
        return "account/sign-up";
    }

    @RequestMapping("/tomypage")
    public String myPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.getPrincipal().equals("anonymousUser")) {
            AccountVO accountVO = accountService.getAccountVOById(authentication.getName());
            if(accountVO != null) {
                model.addAttribute("account", accountVO);
            }
            System.out.println(accountVO);
        }
        return "account/mypage";
    }

    @RequestMapping("/noview")
    public String noview(){return "test"; }

}
