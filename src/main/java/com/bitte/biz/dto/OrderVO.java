package com.bitte.biz.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	//컬럼명 : 주문번호, 아이디, 이름, 핸드폰, 이메일, 주소, 상세주소, 총결제금액, 주문날짜, 배송요청사항, 주문상품개수, 주문현황(1 주문완료, 2 출고완료, 3 배송완료)
	private int orderCode;
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address_kakao;
    private String address_detail;
    private int totalPrice;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDate;
    private String orderReq;
    private int orderCNT;
    private int status;
}
