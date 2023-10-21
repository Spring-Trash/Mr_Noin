package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.member.MemberService;
import com.spring.mrnoin.vo.MemberVo;
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
    MemberService memberService;

    @RequestMapping("/iddupcheck")
    public String idDuplicationcheck(String id, Model model){
        if(id == null || "".equals(id)){
            model.addAttribute("msg", "ID를 확인해주세요.");
            return "sign-up";
        }

        int dupCheck = memberService.getOneMemberById(id);

        if(dupCheck == 0) {
            model.addAttribute("msg", "중복되지 않은 ID입니다.");
            return "sign-up";
        }
        else {
            model.addAttribute("msg", "중복된 ID입니다.");
            return "sign-up";
        }
    }
    @RequestMapping("/register")
    public String register(@Valid MemberVo memberVo, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("msg", "입력정보를 확인해주세요");
            return "sign-up";
        }

        int dupCheck = memberService.getOneMemberById(memberVo.getId());

        if(dupCheck == 0){
            int result = memberService.signUp(memberVo);
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
