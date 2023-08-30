package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	//ȸ�� �÷��� : ���̵�, ���, �̸�, �̸���, ����ȣ, ����, �ּ�, ���, ������
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String phone;
	private String address;
	private String grade;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date userDate;
}
