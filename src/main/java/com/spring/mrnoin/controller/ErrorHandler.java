package com.spring.mrnoin.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErrorHandler implements ErrorController {

    @RequestMapping("/error")
    public String errorHandler(HttpServletRequest request, Model model){
        String status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
        model.addAttribute("code", status);
        return "error/error";
    }

    @GetMapping("/unauthorized")
    public ResponseEntity<Void> unauthorized(){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
