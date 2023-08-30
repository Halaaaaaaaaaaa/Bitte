package com.bitte.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitte.biz.dto.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	//회원 id를 조건으로 사용자 정보 조회
	public UserVO getUser(String id) {
		return mybatis.selectOne("UserMapper.getUser", id);
	}
	
	//회원 존재 여부 조회
	public int confirmID(String id) {
		String password = mybatis.selectOne("UserMapper.confirmID",id);
		
		if (password != null)
			return 1; // id 존재
		else
			return -1;
	}
	
	//회원 로그인 인증(1:성공, 0:비번틀림, -1:비회원)
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
	
	//아이디 중복 검사
	public int check_id(String id) throws Exception{
		return mybatis.selectOne("UserMapper.check_id", id);
	}
		
	//이메일 중복 검사
	public int check_email(String email) throws Exception{
		return mybatis.selectOne("UserMapper.check_email", email);
	}
	
	//회원가입
	public int joinUser(UserVO vo) {
		return mybatis.insert("UserMapper.joinUser", vo);
	}

}
