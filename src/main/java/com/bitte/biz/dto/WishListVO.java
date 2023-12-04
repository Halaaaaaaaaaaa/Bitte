package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WishListVO {
	//회원 컬럼명 : 회원ID, 상품코드, 날짜
	private String id;
	private int p_code;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date wish_date;
}
