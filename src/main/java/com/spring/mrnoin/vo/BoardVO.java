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
public class BoardVO {
    private int no;
    private String subject;
    private String content;
    private String type;
    private int account_no;
    private String nickname;
    private Date registdate;
    private Date updatedate;
    private Date deletedate;
    private int like;
    private int hit;
    private String filename;
    private String filesize;
}
