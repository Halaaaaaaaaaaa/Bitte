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

	@Override	//���� ����ȭ�� all ����Ʈ
	public List<Total_shopVO> total_shopAllList(Total_shopVO vo) {
		return total_shopDao.total_shopAllList(vo);
	}

	@Override	//���� ����ȭ�� ī�װ��� ����Ʈ
	public List<Total_shopVO> total_shopList(String p_category) {
		return total_shopDao.total_shopList(p_category);
	}

	@Override	//���� ������
	public ShopVO total_shopDetail(ShopVO vo) {
		return total_shopDao.total_shopDetail(vo);
	}

}
