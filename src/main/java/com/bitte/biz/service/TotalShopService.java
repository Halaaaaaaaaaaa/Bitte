package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.TotalShopVO;

public interface TotalShopService {
	
	//쇼핑 메인화면 all 리스트
	List<TotalShopVO> total_shopAllList(TotalShopVO vo);
	
	//쇼핑 메인화면 카테고리별 리스트
	List<TotalShopVO> total_shopList(String p_category);
	
	//쇼핑 디테일
	ShopVO total_shopDetail(ShopVO vo);
}
