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
										<a href="logout"><span>Logout</span></a>
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
									<nav>asdfasdgtaetastas</nav>
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
									<a href="#">HOME</a><br> 
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
	
</body>
</html>