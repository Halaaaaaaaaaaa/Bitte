package com.bitte.biz.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

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

	@Override	//회원가입
	public int joinUser(UserVO vo, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (userDao.check_id(vo.getId()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 아이디가 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (userDao.check_email(vo.getEmail()) == 1) {
			out.println("<script>");
			out.println("alert('동일한 이메일이 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			userDao.joinUser(vo);
			return 1;
		}
	}

	@Override	//아이디 중복 검사(ajax)
	public void check_id(String id, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(userDao.check_id(id));
		out.close();
	}

	@Override	//이메일 중복 검사(ajax)
	public void check_email(String email, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(userDao.check_email(email));
		out.close();
	}

	@Override	//마이페이지 회원정보 수정
	public void updateUser(UserVO vo) {
		userDao.updateUser(vo);
	}


}
