package com.bitte.biz.service;

import javax.servlet.http.HttpServletResponse;

import com.bitte.biz.dto.UserVO;

public interface UserService {
	
	//회원 id를 조건으로 사용자 정보 조회
	UserVO getUser(String id);
	
	//회원 존재 여부 조회
	int confirmID(String id);
	
	//회원 로그인 인증
	int loginID(UserVO vo);
	
	//아이디 중복 검사
	void check_id(String id, HttpServletResponse response) throws Exception;

	//이메일 중복 검사
	void check_email(String email, HttpServletResponse response) throws Exception;
	
	//회원가입
	int joinUser(UserVO vo, HttpServletResponse response) throws Exception;
	
	//마이페이지 회원정보 수정
	void updateUser(UserVO vo);
	
	//마이페이지 회원정보 탈퇴
	void deleteUser(String id) throws Exception;
}
