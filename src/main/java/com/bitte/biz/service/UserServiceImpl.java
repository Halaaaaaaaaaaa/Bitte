package com.bitte.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitte.biz.dao.UserDAO;
import com.bitte.biz.dto.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDao;

	@Override	//ȸ�� id�� �������� ����� ���� ��ȸ
	public UserVO getUser(String id) {
		return userDao.getUser(id);
	}
	
	@Override	// ȸ�� ���� ���� ��ȸ
	public int confirmID(String id) {
		return userDao.confirmID(id);
	}

	@Override	//ȸ�� �α��� ����
	public int loginID(UserVO vo) {
		return userDao.loginID(vo);
	}

}
