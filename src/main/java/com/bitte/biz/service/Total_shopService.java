package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.Total_shopVO;

public interface Total_shopService {
	
	//쇼핑 메인화면 all 리스트
	List<Total_shopVO> total_shopAllList(Total_shopVO vo);
	
	//쇼핑 메인화면 카테고리별 리스트
	List<Total_shopVO> total_shopList(Total_shopVO vo);
	
	//쇼핑 디테일
	Total_shopVO total_shopDetail(Total_shopVO vo);
}
