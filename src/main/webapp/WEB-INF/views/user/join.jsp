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
</head>
<body>
	<div class="join-wrap">
		<form id="join" action="join" method="post" name="go_join">
			<table>
				<tr>
					<th>아이디 (영문소문자/숫자 조합, 5~16자)</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="16" name="id" id="id" value="${id}"></td>
				</tr>
				<tr>	
					<td><span id="idChk"></span></td>
				</tr>
				<tr>
					<th>비밀번호 (영문 대소문자/숫자/특수문자 조합, 8자~16자)</th>
				</tr>
				<tr>	
					<td><input type="password" maxlength="16" name="pwd" id="pwd"></td>
				</tr>
				<tr>	
					<td><span id="pwdChk"></span></td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
				</tr>
				<tr>	
					<td><input type="password" maxlength="16" name="pwdCheck" id="pwdCheck"></td>
				</tr>
				<tr>	
					<td><span id="pwdChk2"></span></td>
				</tr>
				<tr>
					<th>이름</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="10" name="name" id="name"></td>
				</tr>
				<tr>	
					<td><span id="nameChk"></span></td>
				</tr>
				<tr>
					<th>이메일</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="50" name="email" id="email"></td>
				</tr>
				<tr>	
					<td><span id="emailChk"></span></td>
				</tr>
				<tr>
					<th>핸드폰</th>
				</tr>
				<tr>	
					<td><input type="text" maxlength="50" name="phone" id="phone" oninput="hypenTel(this)"></td>
				</tr>
				<tr>
					<th>주소</th>
				</tr>
				<tr>	
					<td><input type="text"></td>
				</tr>
			</table>
			
			<button>가입하기</button>
		
		
		</form>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>