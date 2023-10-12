package com.bitte.view;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitte.biz.dto.UserVO;
import com.bitte.biz.service.UserService;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//회원가입 화면
	@GetMapping("/join_page")
	public String joinForm() {
		return "user/join_page";
	}
	
	//로그인 페이지
	@GetMapping(value="login_page")
	public String loginForm() {
		return "user/login_page";
	}
	
	// 로그인 처리
	@PostMapping("/login")
	public String loginAction(UserVO vo, Model model) {
		int u_result = userService.loginID(vo);
		
		if (u_result == 1) {
			model.addAttribute("loginUser", userService.getUser(vo.getId()));
			return "redirect:index"; 
		} else if (u_result == 0) {
			model.addAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
			return "user/login_fail";
		} else {
			model.addAttribute("errorMessage", "계정이 존재하지 않습니다.");
			return "user/login_fail"; // 로그인 실패시
		}
	}
	
	// 로그아웃 처리
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
			status.setComplete();
		return "index";
	}
	
	// 아이디 중복 검사(AJAX)
	@RequestMapping(value = "/check_id", method = RequestMethod.POST)
	public void check_id(@RequestParam("id") String id, HttpServletResponse response) throws Exception{
		userService.check_id(id, response);
	}
		
	// 이메일 중복 검사(AJAX)
	@RequestMapping(value = "/check_email", method = RequestMethod.POST)
	public void check_email(@RequestParam("email") String email, HttpServletResponse response) throws Exception{
		userService.check_email(email, response);
	}
		
	// 회원 가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinUser(@ModelAttribute UserVO vo, RedirectAttributes rttr, HttpServletResponse response) throws Exception{
		rttr.addFlashAttribute("result", userService.joinUser(vo, response));
		return "redirect:index";
	}
	



}
