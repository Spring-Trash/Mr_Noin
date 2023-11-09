package com.spring.mrnoin.controller;

import com.spring.mrnoin.service.AccountService;
import com.spring.mrnoin.service.BoardService;
import com.spring.mrnoin.vo.AccountVO;
import com.spring.mrnoin.vo.BoardVO;
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
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getBoardAll(){
        List<BoardVO> list = boardService.selectAll();
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);

        HttpStatus httpStatus;
        if(list == null) {
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(map, httpStatus);
    }

    @GetMapping("/{no}")
    public ResponseEntity<Map<String, Object>> getBoardOne(@PathVariable int no){
        BoardVO boardVO = boardService.seslectByNo(no);
        Map<String, Object> map = new HashMap<>();
        map.put("board", boardVO);

        HttpStatus httpStatus;
        if(boardVO == null){
            httpStatus = HttpStatus.NOT_FOUND;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(map, httpStatus);
    }

    @PostMapping("")
    public ResponseEntity<Map<String, Object>> registBoardOne(@RequestBody BoardVO boardVO){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);
        boardVO.setAccount_no(accountVO.getNo());
        boardVO.setNickname(accountVO.getNickname());

        int result = boardService.regist(boardVO);

        HttpStatus httpStatus;
        if(result != 1){
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(httpStatus);
    }

    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateBoardOne(@RequestBody BoardVO boardVO){
        BoardVO origin = boardService.seslectByNo(boardVO.getNo());

        if(!origin.getSubject().equals(boardVO.getSubject())){
            origin.setSubject(boardVO.getSubject());
        }
        if(!origin.getContent().equals(boardVO.getContent())){
            origin.setContent(boardVO.getContent());
        }

        int res = boardService.update(origin);
        HttpStatus httpStatus;

        if(res != 1){
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Map<String, Object>> deleteBoardOne(@PathVariable int no){
        String userId = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
        AccountVO accountVO = accountService.getAccountVOById(userId);

        BoardVO boardVO = boardService.seslectByNo(no);
        HttpStatus httpStatus;

        if(boardVO.getType().equals("notice") && accountVO.getRole().equals("USER")){
            httpStatus = HttpStatus.FORBIDDEN;
            return new ResponseEntity<>(httpStatus);
        }

        int res = boardService.delete(no);

        if(res != 1){
            httpStatus = HttpStatus.CONFLICT;
        } else {
            httpStatus = HttpStatus.OK;
        }

        return new ResponseEntity<>(httpStatus);
    }
}
