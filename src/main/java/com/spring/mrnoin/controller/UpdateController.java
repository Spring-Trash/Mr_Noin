package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.member.MemberService;
import com.spring.mrnoin.vo.MemberVo;
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
public class UpdateController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/memberupdate")
    public String memberUpdate(@Valid MemberVo memberVo, BindingResult bindingResult, Model model, HttpSession session){
        if(bindingResult.hasErrors()){
            model.addAttribute("msg", "입력정보를 확인해주세요.");
            return "toupdatepage";
        }

        int result = memberService.memberUpdate(memberVo);

        if(result == 0){
            model.addAttribute("msg", "업데이트에 문제가 발생했습니다.");
            return "toupdatepage";
        }
        else {
            model.addAttribute("msg", "업데이트 성공");
            session.removeAttribute("member");
            session.setAttribute("member", memberVo);
            return "redirect:/";
        }
    }
}
