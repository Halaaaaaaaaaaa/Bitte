package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.WishListVO;

public interface WishListService {
	//마이페이지 위시리스트
	List<WishListVO> allWishList(String id);
		
	//위시리스트 추가
	void insertWishList(WishListVO wish);
}
