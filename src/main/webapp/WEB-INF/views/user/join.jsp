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
	<link rel="stylesheet" type="text/css" href="css/user/join.css" />
	<script type="text/javascript" src="js/user/join.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="join-wrap">
		<form id="join" action="join" method="post">
			<table>
				<tr>
					<th>아이디 (영문소문자/숫자 조합, 5~16자)</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="16" name="id" id="id"></td>
				</tr>
				<tr>	
					<td><span id="id_check"></span></td>
				</tr>
				<tr>
					<th>비밀번호 (영문 대소문자/숫자/특수문자 조합, 8자~16자)</th>
				</tr>
				<tr>	
					<td><input type="password" maxlength="16" name="pwd" id="pwd" onkeyup="pwd_checkF()"></td>
				</tr>
				<tr>	
					<td><span id="pwd_msg"></span></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
				</tr>
				<tr>	
					<td><input type="password" maxlength="16" name="repwd" id="repwd" onkeyup="pwd_checkF()"></td>
				</tr>
				<tr>	
					<td><span id="repwd_msg"></span></td>
				</tr>
				<tr>
					<th>이름</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="10" name="name" id="name" onkeyup="name_checkF()"></td>
				</tr>
				<tr>	
					<td><span id="name_msg"></span></td>
				</tr>
				<tr>
					<th>이메일</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="50" name="email" id="email"></td>
				</tr>
				<tr>	
					<td><span id="email_check"></span></td>
				</tr>
				<tr>
					<th>핸드폰</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="50" name="phone" id="phone" onkeyup="phone_checkF()" oninput="hypenTel(this)"></td>
				</tr>
				<tr>	
					<td><span id="phone_msg"></span></td>
				</tr>
				<tr>
					<th>주소</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="50" name="address" id="address"></td>
				</tr>
			</table>
			
			<button type="submit" id="joinBtn" onClick="go_join()">가입하기</button>
		
		
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/user/join.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	
	<%@ include file="../footer.jsp"%>
</body>
</html>