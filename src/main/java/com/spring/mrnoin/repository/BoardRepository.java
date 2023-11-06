package com.spring.mrnoin.repository;

import com.spring.mrnoin.vo.BoardVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardRepository {

    @Insert("insert into board(no, subject, content, account_no) values(#{no}, #{subject}, #{content}, #{account_no})")
    int regist(BoardVO boardVO);

    @Select("select * from board")
    List<BoardVO> selectAll();

    @Select("select * from board where no = #{no}")
    BoardVO selectByNo(int no);

    @Update("update board set subject = #{subject}, content = #{content}, updatedate = #{updatedate}")
    int update(BoardVO boardVO);

    @Delete("delete from * where no = #{no}")
    int delete(int no);
}
