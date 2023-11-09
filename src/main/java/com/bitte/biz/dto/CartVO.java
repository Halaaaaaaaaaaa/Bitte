package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	//컬럼명 : 장바구니코드, 상품코드, 아이디, 각상품수량
	private int cartCode;
    private int p_code;
    private String id;
    private int itemCNT;
}
