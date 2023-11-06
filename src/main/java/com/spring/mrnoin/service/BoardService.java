package com.spring.mrnoin.service;

import com.spring.mrnoin.vo.BoardVO;

import java.util.List;

public interface BoardService {
    int regist(BoardVO boardVO);
    List<BoardVO> selectAll();
    BoardVO seslectByNo(int no);
    int update(BoardVO boardVO);
    int delete(int no);
}
