package com.spring.mrnoin.controller;

import com.spring.mrnoin.security.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.RequiredArgsConstructor;
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
    AccountService accountService;

    @RequestMapping("/iddupcheck")
    public String idDuplicationcheck(String id, Model model){
        if(id == null || "".equals(id)){
            model.addAttribute("msg", "ID를 확인해주세요.");
            return "sign-up";
        }

        AccountVO dupCheck = accountService.getAccountVOById(id);

        if(dupCheck == null) {
            model.addAttribute("msg", "중복되지 않은 ID입니다.");
            return "sign-up";
        }
        else {
            model.addAttribute("msg", "중복된 ID입니다.");
            return "sign-up";
        }
    }

}
