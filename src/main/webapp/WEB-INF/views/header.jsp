<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BITTE SCHÖN</title>
<link rel="shortcut icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="css/homebase.css" />
<script type="text/javascript" src="js/index.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<header>
		<div class="row">
			<div>
				<div>
					<a href="index"> <img id="main_logo" src="img/main_logo.png">
					</a>
				</div>
			</div>
			<div>
				<div class="row">
					<div class="sub_navi">
						<!-- 검색 -->
						<div class="wrap">
							<form action="" autocomplete="on">
								<input id="search" name="search" type="text" placeholder="What're you looking for ?">
								<input id="search_submit" value="Rechercher" type="submit">
							</form>
						</div>
						
						<!-- 로그인/회원가입 -->
						<c:choose>
							<c:when test="${empty sessionScope.loginUser}">
							<div class="login">
								<input id="toggle-login" type="checkbox"></input> 
								<label for="toggle-login" class="hamburger-login"> 
									<span>Login</span>
								</label>
								<div class="nav-log" id="nav-login">
									<div class="nav-wrapper-login">
										<form method="post" action="login">
											<div class="group">
												<input type="text" placeholder="아이디를 입력하세요" name="id">
													<span class="highlight"></span>
													<span class="bar"></span>
											</div>
											<div class="group">
												<input type="password" placeholder="비밀번호를 입력하세요" name="pwd">
													<span class="highlight"></span>
													<span class="bar"></span>
											</div>
											<div class="findIdPw">
												<a href="#">아이디/비밀번호 찾기</a>
											</div>
											<button type="submit" class="button buttonBlue">
												LOGIN
												<div class="ripples buttonRipples">
													<span class="ripplesCircle"></span>
												</div>
											</button>
											<button type="button" class="button buttonBlack" onclick="location.href='join_form'">
												CREATE ACCOUNT
												<div class="ripples buttonRipples">
													<span class="ripplesCircle"></span>
												</div>
											</button>
											<div class="social-login">
												<span><a href="#">네이버 로그인</a></span>
												<span>&ensp;|&ensp;</span>
												<span><a href="#">카카오 로그인</a></span>
											</div>
										</form>
										
										
									</div>
								</div>
							</div>
							</c:when>
							<c:otherwise>
								<div class="mypage">
									<input id="toggle-login" type="checkbox"></input> 
									<label for="toggle-login" class="hamburger-login"> 
										<a href="#"><span>My Page</span></a>
									</label>
								</div>
								<div class="logout">
									<input id="toggle-login" type="checkbox"></input> 
									<label for="toggle-login" class="hamburger-login"> 
										<a href="logout" onClick="logoutClicked()"><span>Logout</span></a>
									</label>
								</div>
							</c:otherwise>
						</c:choose>
						
						
						<!-- 공지 -->
						<div class="notice">
							<input id="toggle-notice" type="checkbox"></input> 
							<label for="toggle-notice" class="hamburger" style="padding: 0.29em 4em 1.2em 0 !important;"> 
								<span>Notice</span>
							</label>
							<div class="nav" id="nav-notice">
								<div class="nav-wrapper">
									<nav>저희 쇼핑몰은 고객님의 특별한 쇼핑 경험을 위해 언제나 노력합니다.<br>
										고객님을 위해 준비된 다양한 온라인 혜택 및 서비스를 경험해 보세요.<br><br>
										01<br>
										무료교환 온라인 구매의 특성상 제품을 직접 보고 구매하기 어렵기 때문에<br>
										제품을 수령하신 수 사이즈, 컬러 교환을 원하실 경우 무료로 진행하고 있습니다.<br>
										교환 및 반품은 제품 수령 후 7일 이내 접수가 가능하며, <br>
										반품의 경우 반품배송비가 부과됩니다.<br>
										자세한 내용은 자주 묻는 질문을 참고하세요.<br><br>
										02<br>
										주문 및 배송 신규가입시 10%할인 쿠폰이 자동 발급됩니다. <br>
										7만원 이상 제품 구매 시 무료배송 서비스를 제공하며, <br>
										예약배송 제품이 아닌 경우 오후 2시이전 결제 시 당일 출고 진행됩니다. <br>
										배송은 지역 택배사 사정에 따라 약간의 지연이 생길 수 있습니다.<br><br>
										03<br>
										등급별 혜택을 제공합니다. 최근 6개월간의 결제내역을 반영하여<br>
										매월 1일 새로운 회원등급이 부여됩니다.<br>
										자세한 내용은 회원 혜택 안내를 참고하세요. <br><br>
								</div>
							</div>
						</div>
					</div>
					
					<!-- 햄버거 -->
					<div class="ham">
						<input id="toggle-menu" type="checkbox"></input> 
						<label for="toggle-menu" class="hamburger-alt">
							<div class="top-bun"></div>
							<div class="meat"></div>
							<div class="bottom-bun"></div>
						</label>
						<div class="nav-alt" id="nav-menu">
							<div class="nav-wrapper-alt">
								<nav>
									<a href="#">SHOP</a><br> 
									<a href="#">ABOUT</a><br> 
									<a href="#">WORK</a><br> 
									<a href="#">SERVICES</a>
								</nav>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</body>
</html>