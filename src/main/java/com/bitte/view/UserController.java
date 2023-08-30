package com.bitte.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bitte.biz.dto.UserVO;
import com.bitte.biz.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// �α��� ó��
	@PostMapping("/login")
	public String loginAction(UserVO vo, Model model) {
		int u_result = userService.loginID(vo);
		
		if (u_result == 1) {
			model.addAttribute("loginUser", userService.getUser(vo.getId()));
			return "redirect:index"; 
		} else if (u_result == 0) {
			model.addAttribute("errorMessage", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return "user/login_fail";
		} else {
			model.addAttribute("errorMessage", "������ �������� �ʽ��ϴ�.");
			return "user/login_fail"; // �α��� ���н�
		}
	}
	
	// �α׾ƿ� ó��
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
			status.setComplete();
		return "index";
	}
	
	//ȸ������ ȭ��
	@GetMapping("/join_form")
	public String joinForm() {
		return "user/join";
	}

}
