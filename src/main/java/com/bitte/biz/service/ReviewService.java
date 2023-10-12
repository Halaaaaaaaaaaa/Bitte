package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.ReviewVO;

public interface ReviewService {
	
	//후기 등록
	void insertReview(ReviewVO vo);
	
	//후기 리스트
	List<ReviewVO> reviewList(int p_code);

}
