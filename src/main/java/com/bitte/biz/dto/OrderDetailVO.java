package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetailVO {
	//컬럼명 : 주문상세번호, 주문번호, 상품번호, 가격, 개수
	private int orderDetCode;
    private int orderCode;
    private int p_code;
    private int price;
    private int cnt;
}
