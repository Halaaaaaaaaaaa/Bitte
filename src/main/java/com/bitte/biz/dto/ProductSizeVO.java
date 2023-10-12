package com.bitte.biz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductSizeVO {
	//컬럼명 : 상품코드, 상품 사이즈, 상품재고량, 상품판매량
    private int p_code;
    private String p_size;
    private int p_stock;
    private int p_sell;
}
