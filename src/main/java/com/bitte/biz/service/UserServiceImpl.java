package com.bitte.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitte.biz.dao.UserDAO;
import com.bitte.biz.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override	//회원 id를 조건으로 사용자 정보 조회
	public UserVO getUser(String id) {
		return userDao.getUser(id);
	}
	
	@Override	// 회원 존재 여부 조회
	public int confirmID(String id) {
		return userDao.confirmID(id);
	}

	@Override	//회원 로그인 인증
	public int loginID(UserVO vo) {
		return userDao.loginID(vo);
	}

}
