package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product_colorVO {
	//�÷��� : ��ǰ�ڵ�, ��ǰ ����, ��ǰ���, ��ǰ�Ǹŷ�
	private int p_code;
    private String p_color;
    private int p_stock;
    private int p_sell;
    private String p_img;
    private String p_img_detail;
}
