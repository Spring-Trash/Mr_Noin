package com.spring.mrnoin.service;

import com.spring.mrnoin.repository.BoardRepository;
import com.spring.mrnoin.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

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

        BoardVO origin = boardRepository.selectByNo(boardVO.getNo());
        
        // 업데이트 안되는경우 처리

        if(!origin.getSubject().equals(boardVO.getSubject())){
            origin.setSubject(boardVO.getSubject());
        }
        if(!origin.getContent().equals(boardVO.getContent())){
            origin.setContent(boardVO.getContent());
        }
        Date now = Calendar.getInstance().getTime();
        origin.setUpdatedate(now);

        return boardRepository.update(boardVO);
    }

    @Override
    public int delete(int no) {
        // delete안되는경우 처리
        return boardRepository.delete(no);
    }
}
