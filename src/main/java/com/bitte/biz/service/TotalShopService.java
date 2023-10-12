package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.TotalShopVO;

public interface TotalShopService {
	
	//���� ����ȭ�� all ����Ʈ
	List<TotalShopVO> total_shopAllList(TotalShopVO vo);
	
	//���� ����ȭ�� ī�װ��� ����Ʈ
	List<TotalShopVO> total_shopList(String p_category);
	
	//���� ������
	ShopVO total_shopDetail(ShopVO vo);
}
