package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class RegisterController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/iddupcheck")
    public String idDuplicationcheck(String id, Model model){
        if(id == null || "".equals(id)){
            model.addAttribute("msg", "ID를 확인해주세요.");
            return "account/sign-up";
        }

        AccountVO dupCheck = accountService.getAccountVOById(id);

        if(dupCheck == null) {
            model.addAttribute("msg", "중복되지 않은 ID입니다.");
            return "account/sign-up";
        }
        else {
            model.addAttribute("msg", "중복된 ID입니다.");
            return "account/sign-up";
        }
    }

    @RequestMapping("/register")
    public String register(@Valid AccountVO accountVO, BindingResult bindingResult, Model model){
        System.out.println("register-----------------------------");
        if(bindingResult.hasErrors()){
            model.addAttribute( "msg", "입력정보를 확인해주세요");
            return "account/sign-up";
        }

        if(accountService.getAccountVOById(accountVO.getUsername()) == null){
            int result = accountService.signUp(accountVO);
            if(result == 1){
                model.addAttribute("msg", "회원가입 완료");
                return "redirect:/";
            } else {
                model.addAttribute("msg", "회원가입 실패");
                return "account/sign-up";
            }
        } else {
            model.addAttribute("msg", "중복된 ID입니다.");
            return "account/sign-up";
        }
    }

}
