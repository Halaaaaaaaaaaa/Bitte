<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>BITTE SCHÖN</title>
	<link rel="shortcut icon" href="img/favicon.png">
	<link rel="stylesheet" type="text/css" href="css/user/login.css" />
	<script type="text/javascript" src="js/user/join.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="login-wrapper">
		<form method="post" action="login">
			<div class="login-group">
				<input type="text" placeholder="아이디를 입력하세요" name="id"> 
				<span class="login-highlight"></span><span class="login-bar"></span>
			</div>
			<div class="login-group">
				<input type="password" placeholder="비밀번호를 입력하세요" name="pwd">
				<span class="login-highlight"></span><span class="login-bar"></span>
			</div>
			<div class="findIdPwd">
				<a href="#">아이디/비밀번호 찾기</a>
			</div>
			<div class="login_btn">
				<button type="submit" class="buttons buttonBlacks">
					LOGIN
					<div class="ripple buttonRipple">
						<span class="ripplesCircle"></span>
					</div>
				</button>
				<button type="button" class="buttons buttonWhite" onclick="location.href='join_page'">
					CREATE ACCOUNT
					<div class="ripple buttonRipple">
						<span class="ripplesCircle"></span>
					</div>
				</button>
			</div>
			<div class="socialLogin">
				<span><a href="#">네이버 로그인</a></span> <span>&ensp;|&ensp;</span> 
				<span><a href="#">카카오 로그인</a></span>
			</div>
		</form>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>