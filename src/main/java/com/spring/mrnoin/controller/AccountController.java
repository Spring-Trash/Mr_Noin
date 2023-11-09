package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.vo.AccountVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAccountOne(){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);
        Map<String, Object> map = new HashMap<>();
        map.put("account", accountVO);

        HttpStatus httpStatus;

        if(accountVO == null){
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(map, httpStatus);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> registAccountOne(@RequestBody AccountVO accountVO){
        int res = accountService.signUp(accountVO);

        HttpStatus httpStatus;
        if(res != 1){
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(httpStatus);
    }

    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateAccountOne(@RequestBody AccountVO accountVO){
        int res = accountService.accountUpdate(accountVO);

        HttpStatus httpStatus;
        if(res != 1){
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(httpStatus);
    }
}
