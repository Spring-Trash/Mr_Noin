package com.spring.mrnoin.controller;

import com.spring.mrnoin.repository.BoardRepository;
import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.service.BoardService;
import com.spring.mrnoin.vo.AccountVO;
import com.spring.mrnoin.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String list(Model model){

        List<BoardVO> list = boardService.selectAll();
        model.addAttribute("list", list);

        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);
        model.addAttribute("account", accountVO);

        return "board/list";
    }

    @GetMapping("/detail")
    public String detail(int no, Model model){
        BoardVO boardVO = boardService.seslectByNo(no);
        model.addAttribute("board", boardVO);
        return "board/detail";
    }

    @GetMapping("/regist/notice")
    public String registNotice(){
        return "board/regist-notice";
    }

    @PostMapping("/regist/regist")
    public String regist(BoardVO boardVO){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);

        boardVO.setAccount_no(accountVO.getNo());
        boardVO.setNickname(accountVO.getNickname());
        boardVO.setType("notice");

        try {
            boardService.regist(boardVO);
        } catch (Exception e){
            log.info("등록 중 예외 발생 : {}", e.getMessage());
        }

        return "redirect:/board/list";
    }

    @GetMapping("/regist")
    public String regist(Model model){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);
        model.addAttribute("account", accountVO);
        return "board/regist";
    }

    @PostMapping("/regist")
    public String regist(BoardVO boardVO, Model model){

        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);

        boardVO.setAccount_no(accountVO.getNo());
        boardVO.setNickname(accountVO.getNickname());

        try {
            boardService.regist(boardVO);
        } catch (Exception e){
            log.info("등록 중 예외 발생 : {}", e.getMessage());
        }

        return "redirect:/board/list";
    }

    @GetMapping("/update")
    public String update(int no, Model model){
        BoardVO boardVO = boardService.seslectByNo(no);

        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);

        if(boardVO.getType().equals("notice") && accountVO.getRole().equals("USER")){
            model.addAttribute("msg", "관리자 권한이 필요합니다.");
            return "redirect:/board/list";
        }

        model.addAttribute("board", boardVO);
        return "board/update";
    }
    @PostMapping("/update")
    public String update(BoardVO boardVO){

        BoardVO origin = boardService.seslectByNo(boardVO.getNo());

        if(!origin.getSubject().equals(boardVO.getSubject())){
            origin.setSubject(boardVO.getSubject());
        }
        if(!origin.getContent().equals(boardVO.getContent())){
            origin.setContent(boardVO.getContent());
        }

        try{
            boardService.update(origin);
        } catch (Exception e){
            log.info("업데이트 중 예외 발생 : {}", e.getMessage());
        }

        return "redirect:/board/list";
    }

    @GetMapping("/delete")
    public String delete(int no, Model model){

        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);

        BoardVO boardVO = boardService.seslectByNo(no);

        if(boardVO.getType().equals("notice") && accountVO.getRole().equals("USER")){
            model.addAttribute("msg", "관리자 권한이 필요합니다.");
            return "redirect:/list";
        }

        try{
            boardService.delete(no);
        } catch(Exception e){
            log.info("삭제 중 예외 발생 : {}", e.getMessage());
        }
        return "redirect:/board/list";
    }
}
