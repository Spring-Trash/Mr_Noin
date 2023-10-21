package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.member.MemberService;
import com.spring.mrnoin.vo.MemberLoginVO;
import com.spring.mrnoin.vo.MemberVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @RequestMapping("/log-in-confirm")
    public String loginConfirm(@Valid MemberLoginVO memberLoginVO, BindingResult bindingResult, Model model, HttpSession session){

        // 1. 이상한 값 입력했는지 체크
        // 2. 회원가입한 id인지 체크

        // TODO : Error 발생시 입력창에 입력해둔 정보는 유지해야 한다.
        if(bindingResult.hasErrors()){
            model.addAttribute("msg", bindingResult);
            return "log-in";
        }

        MemberVo memberVo = memberService.getOneMemberById(memberLoginVO);

        if(memberVo == null){
            model.addAttribute("msg", "ID, Password를 확인해주세요.");
            return "log-in";
        }
        else {
            session.setAttribute("member", memberVo);
            return "redirect:/";
        }
    }
}
