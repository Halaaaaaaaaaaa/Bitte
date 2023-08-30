package com.bitte.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitte.biz.dto.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//ȸ�� id�� �������� ����� ���� ��ȸ
	public UserVO getUser(String id) {
		return mybatis.selectOne("UserMapper.getUser", id);
	}
	
	//ȸ�� ���� ���� ��ȸ
	public int confirmID(String id) {
		String password = mybatis.selectOne("UserMapper.confirmID",id);
		
		if (password != null)
			return 1; // id ����
		else
			return -1;
	}
	
	//ȸ�� �α��� ����(1:����, 0:���Ʋ��, -1:��ȸ��)
	public int loginID(UserVO vo) {
		int result = -1;
		String password = mybatis.selectOne("UserMapper.confirmID", vo);
		
		if(password == null) {
			result = -1;
		} else if(password.equals(vo.getPwd())) { 
			result = 1;
		} else {
			result = 0;
		}
		return result;
	}
	
	//���̵� �ߺ� �˻�
	public int check_id(String id) throws Exception{
		return mybatis.selectOne("UserMapper.check_id", id);
	}
		
	//�̸��� �ߺ� �˻�
	public int check_email(String email) throws Exception{
		return mybatis.selectOne("UserMapper.check_email", email);
	}
	
	//ȸ������
	public int joinUser(UserVO vo) {
		return mybatis.insert("UserMapper.joinUser", vo);
	}

}
