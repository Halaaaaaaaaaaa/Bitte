package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	//�÷��� : ��ٱ����ڵ�, ��ǰ�ڵ�, ���̵�, ����ǰ����
	private int cartCode;
    private int p_code;
    private String id;
    private int itemCNT;
}
