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

	@Override	//ȸ������
	public int joinUser(UserVO vo, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if (userDao.check_id(vo.getId()) == 1) {
			out.println("<script>");
			out.println("alert('������ ���̵� �ֽ��ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else if (userDao.check_email(vo.getEmail()) == 1) {
			out.println("<script>");
			out.println("alert('������ �̸����� �ֽ��ϴ�.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return 0;
		} else {
			userDao.joinUser(vo);
			return 1;
		}
	}

	@Override	//���̵� �ߺ� �˻�(ajax)
	public void check_id(String id, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(userDao.check_id(id));
		out.close();
	}

	@Override	//�̸��� �ߺ� �˻�(ajax)
	public void check_email(String email, HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		out.println(userDao.check_email(email));
		out.close();
	}

	@Override	//���������� ȸ������ ����
	public void updateUser(UserVO vo) {
		userDao.updateUser(vo);
	}


}
