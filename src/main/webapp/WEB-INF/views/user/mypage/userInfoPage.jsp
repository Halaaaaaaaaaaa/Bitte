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
	<link rel="stylesheet" type="text/css" href="css/user/mypage/userInfoPage.css" />
	<script type="text/javascript" src="js/user/mypage.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<div class="userInfo">
		<div class="info">
			<p>회원정보</p>
			<hr>
		</div>
		<form name="user_update" id="user_update" method="post">
			<!-- 회원정보 표출 및 수정 -->
			<div align="center">
				<table>
					<tr>
						<th>아이디 *</th>
						<td><input maxlength="16" id="id" type="text" value="${users.id }" readonly="readonly"></td>
					</tr>
					<tr>	
						<th></th>
						<td></td>
					</tr>
					<tr>
						<th>비밀번호 *</th>
						<td><input maxlength="16" id="pwd" type="password" value="${users.pwd }" onkeyup="pwd_checkF()"></td>
					</tr>
					<tr>	
						<th></th>
						<td><span id="pwd_msg"></span></td>
					</tr>
					<tr>
						<th>비밀번호 확인 *</th>
						<td><input type="password" maxlength="16" id="repwd" onkeyup="pwd_checkF()"></td>
					</tr>
					<tr>	
						<th></th>
						<td><span id="repwd_msg"></span></td>
					</tr>
					<tr>
						<th>이름 *</th>
						<td><input maxlength="10" id="name" value="${users.name }" onkeyup="name_checkF()"></td>
					</tr>
					<tr>	
						<th></th>
						<td><span id="name_msg"></span></td>
					</tr>
					<tr>
						<th rowspan="2">주소 *</th>
						<td style="height:55px;"><input type="text" name="address_kakao" id="address_kakao" value="${users.address_kakao }" onkeyup="address_checkF()" readonly /></td>
					</tr>
					<tr>
						<td><input type="text" maxlength="50" name="address_detail" id="address_detail" value="${users.address_detail }" onkeyup="address_checkF()" /></td>
					</tr>
					<tr>	
						<th></th>
						<td><span id="addr_msg"></span></td>
					</tr>
					<tr>
						<th>휴대전화 *</th>
						<td><input type="text" maxlength="15" id="phone" value="${users.phone }" onkeyup="phone_checkF()" oninput="hypenTel(this)"></td>
					</tr>
					<tr>	
						<td><span id="phone_msg"></span></td>
					</tr>
					<tr>
						<th>이메일 *</th>
						<td><input type="text" maxlength="50" id="email" value="${users.email }"></td>
					</tr>
					<tr>	
						<th></th>
						<td><span id="email_check"></span></td>
					</tr>
				</table>	
			</div>
			<!-- 회원정보수정, 회원탈퇴 버튼 -->
			<div class="btn">
				<input class="btn-update" type="button" value="회원정보수정">&emsp;
				<input class="btn-delete" type="button" value="회원탈퇴">
			</div>
		</form>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/user/mypage.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	window.onload = function(){
	    document.getElementById("address_kakao").addEventListener("click", function(){ //주소입력칸을 클릭하면
	        //카카오 지도 발생
	        new daum.Postcode({
	            oncomplete: function(data) { //선택시 입력값 세팅
	                document.getElementById("address_kakao").value = data.address; // 주소 넣기
	                document.querySelector("input[name=address_detail]").focus(); //상세입력 포커싱
	            }
	        }).open();
	    });
	}
</script>
</html>