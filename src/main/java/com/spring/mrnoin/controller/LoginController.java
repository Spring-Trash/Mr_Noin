package com.spring.mrnoin.controller;

import com.spring.mrnoin.Security.AccountService;
import com.spring.mrnoin.Security.AccountVO;
import com.spring.mrnoin.vo.AccountLoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    AccountService accountService;

    @RequestMapping("/loginconfirm")
    public String loginConfirm(@Valid AccountLoginVO accountLoginVO, BindingResult bindingResult, Model model, HttpSession session){

        // 1. 이상한 값 입력했는지 체크
        // 2. 회원가입한 id인지 체크

        // TODO : Error 발생시 입력창에 입력해둔 정보는 유지해야 한다. -> 회원가입에서
        if(bindingResult.hasErrors()){
            model.addAttribute("msg", bindingResult);
            return "log-in";
        }

        AccountVO accountVO = accountService.getOneAccountToLogin(accountLoginVO);

        if(accountVO == null){
            model.addAttribute("msg", "ID, Password를 확인해주세요.");
            return "log-in";
        }
        else {
            session.setAttribute("account", accountVO);
            return "redirect:/";
        }
    }
}
