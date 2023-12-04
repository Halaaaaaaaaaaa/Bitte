package com.bitte.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitte.biz.dao.WishListDAO;
import com.bitte.biz.dto.WishListVO;

@Service
public class WishListServiceImpl implements WishListService {
	
	@Autowired
	private WishListDAO wishDao;

	@Override
	public List<WishListVO> allWishList(String id) {
		return wishDao.allWishList(id);
	}

	@Override
	public void insertWishList(WishListVO wish) {
		wishDao.insertWishList(wish);
	}
}
