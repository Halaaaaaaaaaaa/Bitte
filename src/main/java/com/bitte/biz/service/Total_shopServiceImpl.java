package com.bitte.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitte.biz.dao.Total_shopDAO;
import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.Total_shopVO;

@Service
public class Total_shopServiceImpl implements Total_shopService {
	
	@Autowired
	private Total_shopDAO total_shopDao;

	@Override	//쇼핑 메인화면 all 리스트
	public List<Total_shopVO> total_shopAllList(Total_shopVO vo) {
		return total_shopDao.total_shopAllList(vo);
	}

	@Override	//쇼핑 메인화면 카테고리별 리스트
	public List<Total_shopVO> total_shopList(String p_category) {
		return total_shopDao.total_shopList(p_category);
	}

	@Override	//쇼핑 디테일
	public ShopVO total_shopDetail(ShopVO vo) {
		return total_shopDao.total_shopDetail(vo);
	}

}
