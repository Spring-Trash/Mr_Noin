package com.spring.mrnoin.frontcontroller;

import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/page")
public class FrontController {

    @Autowired
    AccountService accountService;

    @GetMapping()
    public String index(){
        return "/index";
    }
    @GetMapping("/index")
    public String home(){
        return "redirect:/";
    }

    @GetMapping("/account/login")
    public String loginForm(){
        return "account/log-in";
    }

    @GetMapping("/account/signup")
    public String signUpForm(){
        return "account/sign-up";
    }

    @GetMapping("/account/mypage")
    public String myPage(){
        return "account/mypage";
    }

    @GetMapping("/account/update")
    public String toUpdatePage(){
        return "account/update";
    }

    @GetMapping("/account/logout")
    public String logout(){
        SecurityContextHolder.clearContext();
        return "/";
    }


    @GetMapping("/notice")
    public String notice(){
        return "notice/notice";
    }


    @GetMapping("/notice/regist")
    public String registNotice(){
        return "board/regist-notice";
    }


    @GetMapping("/board/list")
    public String board(){
        return "board/list";
    }

    @GetMapping("/board/regist")
    public String boardRegist(){
        return "board/regist";
    }

    @GetMapping("/board/detail")
    public String boardDetail(){
        return "board/detail";
    }

    @GetMapping("/board/update")
    public String boardUpdate(){
        return "board/update";
    }
}
