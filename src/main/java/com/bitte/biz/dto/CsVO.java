package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CsVO {
	//고객센터 컬럼명: 문의번호, 회원id, 상품번호, 이메일, 문의제목, 문의내용, 문의상태, 작성일, 답변
	private int c_code;
	private String varchar;
	private int p_code;
	private String c_email;
	private String c_title;
	private String c_content;
	private String c_status;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date c_regdate;
	private String reply;
}


