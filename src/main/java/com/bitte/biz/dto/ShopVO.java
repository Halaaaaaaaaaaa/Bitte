package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ShopVO {
	//컬럼명 : 상품코드, 상품분류번호, 상품명, 상품가격, 상품등록일, 상품색상, 상품재고량, 상품판매량, 상품이미지
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
