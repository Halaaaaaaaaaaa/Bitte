package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductSizeVO {
	//�÷��� : ��ǰ�ڵ�, ��ǰ ������, ��ǰ���, ��ǰ�Ǹŷ�
    private int p_code;
    private String p_size;
    private int p_stock;
    private int p_sell;
}
