package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailVO {
	//�÷��� : �ֹ��󼼹�ȣ, �ֹ���ȣ, ��ǰ��ȣ, ����, ����
	private int orderDetCode;
    private int orderCode;
    private int p_code;
    private int price;
    private int cnt;
}
