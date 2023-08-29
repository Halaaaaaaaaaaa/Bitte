<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BITTE SCHÖN</title>
<link rel="shortcut icon" href="img/favicon.png">
<link rel="stylesheet" type="text/css" href="css/homebase.css" />
</head>
<body>
	<div>
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
						<div id="wrap">
							<form action="" autocomplete="on">
								<input id="search" name="search" type="text" placeholder="What're you looking for ?">
								<input id="search_submit" value="Rechercher" type="submit">
							</form>
						</div>
						
						<!-- 로그인/회원가입 -->
						<div>
							<input id="toggle-login" type="checkbox"></input> 
							<label for="toggle-login" class="hamburger-login"> 
								<span>Login</span>
							</label>
							<div class="nav-log" id="nav-login">
								<div class="nav-wrapper-login">
									<nav>Login</nav>
								</div>
							</div>
						</div>
						
						<!-- 공지 -->
						<div>
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
					<div>
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
	</div>
	
</body>
</html>