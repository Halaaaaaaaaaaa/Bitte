package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Total_shopVO {
	//�÷��� : ��ǰ�ڵ�, ��ǰ�з���ȣ, ��ǰ��, ��ǰ����, ��ǰ�����
	private int p_code;
	private String p_category;
	private String p_name;
	private String p_price;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date p_regdate;
}
