package com.bitte.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitte.biz.dto.ReviewVO;

@Repository
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//�ı� ���
	public void insertReview(ReviewVO vo) {
		mybatis.insert("ReviewMapper.insertReview", vo);
	}
	
	//�ı� ����Ʈ
	public List<ReviewVO> reviewList(int p_code) {
		return mybatis.selectList("ReviewMapper.reviewList", p_code);
	}

}
