package com.spring.mrnoin.service;

import com.spring.mrnoin.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;
    @Test
    void regist() {
        BoardVO boardVO = new BoardVO();
        boardVO.setAccount_no(1);
        boardVO.setSubject("안녕");
        boardVO.setContent("내용");

        int result = boardService.regist(boardVO);

        assertEquals(result, 1);
    }

    @Test
    void selectAll() {
        List<BoardVO> list = boardService.selectAll();
        log.info("list : {}", list);
        assertEquals(list.size(), 1);
    }

    @Test
    void seslectByNo() {
        BoardVO boardVO = boardService.seslectByNo(1);
        log.info("boardVO : {}", boardVO);
        assertNotNull(boardVO);
    }

    @Test
    void update() {
        BoardVO boardVO = boardService.seslectByNo(1);
        boardVO.setSubject("제목");
        log.info("boardVO : {}", boardVO);
        int result = boardService.update(boardVO);
        assertEquals(1, result);
    }

    @Test
    void delete() {
        int result = boardService.delete(1);
        assertEquals(1, result);
    }
}