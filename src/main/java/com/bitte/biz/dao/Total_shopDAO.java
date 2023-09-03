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
	
	//쇼핑 메인화면 all 리스트
	public List<Total_shopVO> total_shopAllList(Total_shopVO vo) {
		return mybatis.selectList("Total_shopMapper.total_shopAllList",vo);
	}
	
	//쇼핑 메인화면 카테고리별 리스트
	public List<Total_shopVO> total_shopList(Total_shopVO vo) {
		return mybatis.selectList("Total_shopMapper.total_shopList",vo);
	}
	
	//쇼핑 디테일
	public Total_shopVO total_shopDetail(Total_shopVO vo) {
		return mybatis.selectOne("Total_shopMapper.total_shopDetail",vo);
	}

}
