package com.bitte.biz.service;

import javax.servlet.http.HttpServletResponse;

import com.bitte.biz.dto.UserVO;

public interface UserService {
	
	//ȸ�� id�� �������� ����� ���� ��ȸ
	UserVO getUser(String id);
	
	//ȸ�� ���� ���� ��ȸ
	int confirmID(String id);
	
	//ȸ�� �α��� ����
	int loginID(UserVO vo);
	
	//���̵� �ߺ� �˻�
	void check_id(String id, HttpServletResponse response) throws Exception;

	//�̸��� �ߺ� �˻�
	void check_email(String email, HttpServletResponse response) throws Exception;
	
	//ȸ������
	int joinUser(UserVO vo, HttpServletResponse response) throws Exception;
	
	//���������� ȸ������ ����
	void updateUser(UserVO vo);
	
	//���������� ȸ������ Ż��
	void deleteUser(String id) throws Exception;
}
