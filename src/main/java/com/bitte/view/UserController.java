package com.bitte.view;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	//ȸ������ ȭ��
	@GetMapping("/join_page")
	public String joinForm() {
		return "user/join_page";
	}
	
	//�α��� ������
	@GetMapping(value="login_page")
	public String loginForm() {
		return "user/login_page";
	}
	
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
	
	// ���̵� �ߺ� �˻�(AJAX)
	@RequestMapping(value = "/check_id", method = RequestMethod.POST)
	public void check_id(@RequestParam("id") String id, HttpServletResponse response) throws Exception{
		userService.check_id(id, response);
	}
		
	// �̸��� �ߺ� �˻�(AJAX)
	@RequestMapping(value = "/check_email", method = RequestMethod.POST)
	public void check_email(@RequestParam("email") String email, HttpServletResponse response) throws Exception{
		userService.check_email(email, response);
	}
		
	// ȸ�� ����
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinUser(@ModelAttribute UserVO vo, RedirectAttributes rttr, HttpServletResponse response) throws Exception{
		rttr.addFlashAttribute("result", userService.joinUser(vo, response));
		return "redirect:login_page";
	}
	
	// ����������
	@GetMapping("/mypage")
	public String mypage(Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "user/session_fail";
		}
		
		model.addAttribute("user", loginUser);
		logger.info(loginUser.toString());
		
		return "user/mypage";
	}
	
	//����������
	@RequestMapping(value = "/loadPage", method = RequestMethod.GET)
	public String loadPage(
	        @RequestParam(required = false) String userInfoPage,
	        @RequestParam(required = false) String deliveryPage,
	        @RequestParam(required = false) String personalInqPage,
	        @RequestParam(required = false) String productInqPage,
	        @RequestParam(required = false) String orderPage,
	        @RequestParam(required = false) String cancelPage,
	        @RequestParam(required = false) String wishlistPage) {

	    if ("userInfoPage".equals(userInfoPage)) {
	        return "user/mypage/userInfoPage";
	    } else if ("deliveryPage".equals(deliveryPage)) {
	        return "user/mypage/deliveryPage";
	    } else if ("personalInqPage".equals(personalInqPage)) {
	        return "user/mypage/personalInqPage";
	    } else if ("productInqPage".equals(productInqPage)) {
	        return "user/mypage/productInqPage";
	    } else if ("orderPage".equals(orderPage)) {
	        return "user/mypage/orderPage";
	    } else if ("cancelPage".equals(cancelPage)) {
	        return "user/mypage/cancelPage";
	    } else if ("wishlistPage".equals(wishlistPage)) {
	        return "user/mypage/wishlistPage";
	    } else {
	        return "user/mypage/userInfoPage";
	    }
	}
	
	//���������� �ֹ� ���� ȭ��
	@GetMapping(value="/orderPage")
	public String mypageOrder() {
		return "user/mypage/orderPage";
	}
	
	//���������� ����� ���� ȭ��
	@GetMapping("/userInfoPage")
	public String mypageUserInfo(UserVO vo, Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "user/session_fail";
		}
		
		userService.updateUser(vo);

		model.addAttribute("loginUser", userService.getUser(vo.getId()));
		model.addAttribute("users", loginUser);
		return "user/mypage/userInfoPage";
		
	}



}
