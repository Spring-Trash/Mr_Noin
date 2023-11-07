package com.spring.mrnoin.controller;

import com.spring.mrnoin.repository.BoardRepository;
import com.spring.mrnoin.service.BoardService;
import com.spring.mrnoin.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public String list(Model model){

        List<BoardVO> list = boardService.selectAll();
        model.addAttribute("list", list);

        return "board/board";
    }
}
