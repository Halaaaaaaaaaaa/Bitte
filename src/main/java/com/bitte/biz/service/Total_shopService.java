package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.Total_shopVO;

public interface Total_shopService {
	
	//���� ����ȭ�� all ����Ʈ
	List<Total_shopVO> total_shopAllList(Total_shopVO vo);
	
	//���� ����ȭ�� ī�װ��� ����Ʈ
	List<Total_shopVO> total_shopList(Total_shopVO vo);
	
	//���� ������
	Total_shopVO total_shopDetail(Total_shopVO vo);
}
