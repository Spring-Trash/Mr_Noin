package com.spring.mrnoin.service;

import com.spring.mrnoin.repository.BoardRepository;
import com.spring.mrnoin.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public int regist(BoardVO boardVO) {
        return boardRepository.regist(boardVO);
    }

    @Override
    public List<BoardVO> selectAll() {
        return boardRepository.selectAll();
    }

    @Override
    public BoardVO seslectByNo(int no) {
        return boardRepository.selectByNo(no);
    }

    @Override
    public int update(BoardVO boardVO) {
        return boardRepository.update(boardVO);
    }

    @Override
    public int delete(int no) {
        return boardRepository.delete(no);
    }
}
