package com.bitte.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitte.biz.dto.Total_shopVO;

@Repository
public class Total_shopDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//���� ����ȭ�� all ����Ʈ
	public List<Total_shopVO> total_shopAllList(Total_shopVO vo) {
		return mybatis.selectList("Total_shopMapper.total_shopAllList",vo);
	}
	
	//���� ����ȭ�� ī�װ��� ����Ʈ
	public List<Total_shopVO> total_shopList(Total_shopVO vo) {
		return mybatis.selectList("Total_shopMapper.total_shopList",vo);
	}
	
	//���� ������
	public Total_shopVO total_shopDetail(Total_shopVO vo) {
		return mybatis.selectOne("Total_shopMapper.total_shopDetail",vo);
	}

}
