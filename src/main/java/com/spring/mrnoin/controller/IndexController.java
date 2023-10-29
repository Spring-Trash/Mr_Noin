package com.spring.mrnoin.controller;

import com.spring.mrnoin.security.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
        return "log-in";
    }

    @RequestMapping("/tosignuppage")
    public String signUpForm(){
        return "sign-up";
    }

//    @RequestMapping("/logout")
//    public String logOut(HttpSession session){
//        session.removeAttribute("member");
//        return "index";
//    }

    @RequestMapping("/tomypage")
    public String myPage(){
        return "mypage";
    }

    @RequestMapping("/noview")
    public String noview(){return "test"; }

    @RequestMapping("/register")
    public String register(@Valid AccountVO accountVO, BindingResult bindingResult, Model model){
        System.out.println("register-----------------------------");
        if(bindingResult.hasErrors()){
            model.addAttribute( "msg", "입력정보를 확인해주세요");
            return "sign-up";
        }

        if(accountService.getAccountVOById(accountVO.getUsername()) == null){
            int result = accountService.signUp(accountVO);
            if(result == 1){
                model.addAttribute("msg", "회원가입 완료");
                return "redirect:/";
            } else {
                model.addAttribute("msg", "회원가입 실패");
                return "sign-up";
            }
        } else {
            model.addAttribute("msg", "중복된 ID입니다.");
            return "sign-up";
        }
    }

}
