package com.bitte.biz.service;

import com.bitte.biz.dto.UserVO;

public interface UserService {
	
	// ȸ�� id�� �������� ����� ���� ��ȸ
	UserVO getUser(String id);
	
	// ȸ�� ���� ���� ��ȸ
	int confirmID(String id);
	
	//ȸ�� �α��� ����
	int loginID(UserVO vo);

}
