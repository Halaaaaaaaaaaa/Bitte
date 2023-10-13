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
	//������ �÷���: ���ǹ�ȣ, ȸ��id, ��ǰ��ȣ, �̸���, ��������, ���ǳ���, ���ǻ���, �ۼ���, �亯
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


