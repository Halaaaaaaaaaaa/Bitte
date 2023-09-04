package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ShopVO {
	//�÷��� : ��ǰ�ڵ�, ��ǰ�з���ȣ, ��ǰ��, ��ǰ����, ��ǰ�����, ��ǰ����, ��ǰ���, ��ǰ�Ǹŷ�, ��ǰ�̹���
    private int p_code;
    private int p_category;
    private String p_name;
    private String p_price;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date p_regdate;
    private String p_color;
    private int p_color_stock;
    private int p_color_sell;
    private String p_img;
    private String p_size;
    private int p_size_stock;
    private int p_size_sell;
    
}
