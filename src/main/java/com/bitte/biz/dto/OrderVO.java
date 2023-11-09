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
	//�÷��� : �ֹ���ȣ, ���̵�, �̸�, �ڵ���, �̸���, �ּ�, ���ּ�, �Ѱ����ݾ�, �ֹ���¥, ��ۿ�û����, �ֹ���ǰ����, �ֹ���Ȳ(1 �ֹ��Ϸ�, 2 ���Ϸ�, 3 ��ۿϷ�)
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
