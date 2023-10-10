package com.bitte.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitte.biz.dao.TotalShopDAO;
import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.TotalShopVO;

@Service
public class TotalShopServiceImpl implements TotalShopService {
	
	@Autowired
	private TotalShopDAO totalShopDao;

	@Override	//쇼핑 메인화면 all 리스트
	public List<TotalShopVO> total_shopAllList(TotalShopVO vo) {
		return totalShopDao.total_shopAllList(vo);
	}

	@Override	//쇼핑 메인화면 카테고리별 리스트
	public List<TotalShopVO> total_shopList(String p_category) {
		return totalShopDao.total_shopList(p_category);
	}

	@Override	//쇼핑 디테일
	public ShopVO total_shopDetail(ShopVO vo) {
		return totalShopDao.total_shopDetail(vo);
	}

}
