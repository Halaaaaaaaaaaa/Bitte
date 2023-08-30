package com.bitte.biz.service;

import com.bitte.biz.dto.UserVO;

public interface UserService {
	
	// 회원 id를 조건으로 사용자 정보 조회
	UserVO getUser(String id);
	
	// 회원 존재 여부 조회
	int confirmID(String id);
	
	//회원 로그인 인증
	int loginID(UserVO vo);

}
