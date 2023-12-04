package com.bitte.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitte.biz.dto.ReviewVO;
import com.bitte.biz.dto.WishListVO;

@Repository
public class WishListDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//마이페이지 위시리스트
	public List<WishListVO> allWishList(String id) {
		return mybatis.selectList("WishListMapper.allWishList", id);
	}	
	
	//위시리스트 추가
	public void insertWishList(WishListVO wish) {
		mybatis.insert("WishListMapper.insertWishList", wish);
	}

}
