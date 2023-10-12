package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewVO {
	//�ı� ���̺� : �ı��ȣ, ���̵�, ������ȣ, �ı��ۼ���, ����, ���� 
	private int r_code;
	private String id;
	private int p_code;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;
	private int r_point;
	private String r_content;
}
