package com.bitte.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitte.biz.dto.ShopVO;
import com.bitte.biz.dto.TotalShopVO;

@Repository
public class TotalShopDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//���� ����ȭ�� all ����Ʈ
	public List<TotalShopVO> total_shopAllList(TotalShopVO vo) {
		return mybatis.selectList("Total_shopMapper.total_shopAllList",vo);
	}
	
	//���� ����ȭ�� ī�װ��� ����Ʈ
	public List<TotalShopVO> total_shopList(String p_category) {
		return mybatis.selectList("Total_shopMapper.total_shopList",p_category);
	}
	
	//���� ������
	public ShopVO total_shopDetail(ShopVO vo) {
		return mybatis.selectOne("Total_shopMapper.total_shopDetail",vo);
	}

}
