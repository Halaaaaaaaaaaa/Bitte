package com.bitte.biz.service;

import java.util.List;

import com.bitte.biz.dto.WishListVO;

public interface WishListService {
	//���������� ���ø���Ʈ
	List<WishListVO> allWishList(String id);
		
	//���ø���Ʈ �߰�
	void insertWishList(WishListVO wish);
}
