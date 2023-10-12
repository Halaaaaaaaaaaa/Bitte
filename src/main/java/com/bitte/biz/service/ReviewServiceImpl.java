package com.bitte.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitte.biz.dao.ReviewDAO;
import com.bitte.biz.dto.ReviewVO;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDAO reviewDao;

	@Override	//후기 등록
	public void insertReview(ReviewVO vo) {
		reviewDao.insertReview(vo);
	}

	@Override	//후기 리스트
	public List<ReviewVO> reviewList(int p_code) {
		return reviewDao.reviewList(p_code);
	}

}
