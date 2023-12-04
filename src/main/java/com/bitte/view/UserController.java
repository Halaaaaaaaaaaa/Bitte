package com.bitte.view;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitte.biz.dto.UserVO;
import com.bitte.biz.dto.WishListVO;
import com.bitte.biz.service.UserService;
import com.bitte.biz.service.WishListService;

@Controller
@SessionAttributes("loginUser")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	@Autowired
	private WishListService wishService;
	
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
		return "redirect:login_page";
	}
	
	// 마이페이지
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
	
	//마이페이지
	@RequestMapping(value = "/loadPage", method = RequestMethod.GET)
	public String loadPage(
	        @RequestParam(required = false) String userInfoPage,
	        @RequestParam(required = false) String deliveryPage,
	        @RequestParam(required = false) String personalInqPage,
	        @RequestParam(required = false) String productInqPage,
	        @RequestParam(required = false) String orderPage,
	        @RequestParam(required = false) String cancelPage,
	        @RequestParam(required = false) String wishListPage) {

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
	    } else if ("wishlistPage".equals(wishListPage)) {
	        return "user/mypage/wishListPage";
	    } else {
	        return "user/mypage/userInfoPage";
	    }
	}
	
	//마이페이지 주문 내역 화면
	@GetMapping(value="/orderPage")
	public String mypageOrder() {
		return "user/mypage/orderPage";
	}
	
	//마이페이지 사용자 정보 화면
	@GetMapping("/userInfoPage")
	public String mypageUserInfo(UserVO vo, Model model, HttpSession session) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "user/session_fail";
		}
		
		model.addAttribute("users", loginUser);
		
		return "user/mypage/userInfoPage";
	}
	
	//마이페이지 위시리스트 내역 화면
	@GetMapping(value="/wishListPage")
	public String mypageWishList(UserVO vo, Model model, HttpSession session, WishListVO wish) {
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "user/session_fail";
		}
		
		List<WishListVO> wishList = wishService.allWishList(loginUser.getId());
		
		model.addAttribute("wishList", wishList);
		logger.info(wishList.toString());
		
		return "user/mypage/wishListPage";
	}

	
	//마이페이지 사용자 정보 수정
	@PostMapping("/userInfoUpdate")
	public String mypageUserUpdate(UserVO vo, HttpSession session, Model model) {

		userService.updateUser(vo);

		model.addAttribute("loginUser", userService.getUser(vo.getId()));
		model.addAttribute("users", vo);
		
		return "redirect:mypage";
	}

	//마이페이지 사용자 정보 탈퇴 
	@ResponseBody
	@PostMapping(value = "/userInfoDelete", produces = "application/text; charset=utf8")
	public String memberDelete(UserVO vo, HttpSession session, SessionStatus status) throws Exception {

		try {
			UserVO loginUser = (UserVO) session.getAttribute("loginUser");
			String message = "";
			
			if (loginUser.getPwd().equals(vo.getPwd())) {
				userService.deleteUser(loginUser.getId());
				//추후 주문내역 존재할 경우 탈퇴 시 주문내역 삭제하는 로직 작성
				status.setComplete();
				 message = "success";
			} else {
				message = "fail"; 
			}
			
			return message;
		} catch (NullPointerException e) {
			return "<script>alert('');location.href='login_page';</script>";
		}
	}


}
