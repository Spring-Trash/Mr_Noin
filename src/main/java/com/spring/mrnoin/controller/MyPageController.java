package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MyPageController {

    @Autowired
    private final AccountService accountService;

    @RequestMapping("toupdatepage")
    public String toUpdatePage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!authentication.getPrincipal().equals("anonymousUser")) {
            AccountVO accountVO = accountService.getAccountVOById(authentication.getName());
            if(accountVO != null) {
                model.addAttribute("account", accountVO);
            }
        }
        return "account/update";
    }
}
