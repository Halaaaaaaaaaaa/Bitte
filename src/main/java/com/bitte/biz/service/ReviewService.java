package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.ReviewVO;

public interface ReviewService {
	
	//�ı� ���
	void insertReview(ReviewVO vo);
	
	//�ı� ����Ʈ
	List<ReviewVO> reviewList(int p_code);

}
