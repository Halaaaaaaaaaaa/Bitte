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
	//�÷��� : ��ǰ�ڵ�, ��ǰ�з���ȣ, ��ǰ��, ��ǰ����, ���, �Ǹŷ�, ��ǰ��ǥ�̹���, ��ǰ�����
	private int p_code;
	private String p_category;
	private String p_name;
	private String p_price;
	private int p_stock;
	private int p_sell;
	private String p_img;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date p_regdate;
	
}
