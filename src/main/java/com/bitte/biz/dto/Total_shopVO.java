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
	//컬럼명 : 상품코드, 상품분류번호, 상품명, 상품가격, 상품등록일
	private int p_code;
	private String p_category;
	private String p_name;
	private String p_price;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date p_regdate;
}
