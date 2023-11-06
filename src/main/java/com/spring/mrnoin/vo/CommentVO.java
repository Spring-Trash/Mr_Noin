package com.spring.mrnoin.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentVO {
    private int no;
    private String comment;
    private int board_no;
    private int account_no;
    private Date registdate;
    private Date updatedate;
    private Date deletedate;
    private int like;
}
