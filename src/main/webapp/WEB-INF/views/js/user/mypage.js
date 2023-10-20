
//마이페이지 회원 정보 페이지
function loadPage(userInfoPage) {
    $.ajax({
        url: userInfoPage,
        success: function (data) {
            $('#content').html(data);
        }
    });
}

//마이페이지 주문 내역 페이지
function loadPage(orderPage) {
    $.ajax({
        url: orderPage,
        success: function (data) {
            $('#content').html(data);
        }
    });
}

//비밀번호 유효성 검사
function pwd_checkF(){
	var pwd = $("#pwd").val();
	var repwd = $("#repwd").val();
	var num = pwd.search(/[0-9]/g);
	var eng = pwd.search(/[a-z]/ig);
	var spe = pwd.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(pwd == "" || pwd == null) {
		$("#pwd_msg").html("*비밀번호를 입력해주세요.").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else if(pwd.search(/\s/) != -1){
		$("#pwd_msg").html("*비밀번호는 공백 없이 입력해주세요.").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else if(num < 0 || eng < 0 || spe < 0){
		$("#pwd_msg").html("*영문,숫자,특수문자를 혼합하여 입력해주세요.").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else if(pwd.length < 8 || pwd.length > 12) {
		$("#pwd_msg").html("*비밀번호는 8자 이상 16자 이내로 입력해주세요").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else if(repwd == "" || repwd == null) {
		$("#repwd_msg").html("*비밀번호를 확인해주세요.").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else {
		$("#pwd_msg").html("");
		$("#btn-update").prop("disabled", false);
	} 
	if(pwd != repwd){
		$("#repwd_msg").html("*비밀번호가 일치하지 않습니다.").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else {
		$("#repwd_msg").html("");
		$("#btn-update").prop("disabled", false);
	}
}

//이름 유효성 검사
function name_checkF(){
	var name = $("#name").val();
	
	if (name == "" || name == null) {
		$("#name_msg").html("*이름을 입력해주세요.").css("color", "red");
		$("#btn-update").prop("disabled", true);
	} else if (name.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?0-9]/gi) !== -1) { 
	    $("#name_msg").html("*이름을 올바로 입력해주세요.").css("color", "red");
	    $("#btn-update").prop("disabled", true);
	} else if (name.length < 2) { 
	    $("#name_msg").html("*이름을 올바로 입력해주세요.").css("color", "red");
	    $("#btn-update").prop("disabled", true);
	} else {
		$("#name_msg").html("");
		$("#btn-update").prop("disabled", false);
	}
}

//휴대폰 유효성 검사
function phone_checkF(){
	var phone = $("#phone").val(); 
	
	if (phone == "" || phone == null) {
        $("#phone_msg").html("*핸드폰 번호를 입력해주세요.").css("color", "red");
        $("#btn-update").prop("disabled", true);
    } else {
        $("#phone_msg").html("");
        $("#btn-update").prop("disabled", false);
    }
}


//전화번호 하이픈 자동 생성
function hypenTel(target) {
    const maxLength = 11;
    let value = target.value.replace(/[^0-9]/g, '');
    value = value.substring(0, maxLength);

    target.value = value.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

//아이디&이메일, 가입하기 유효성 검사
$(function() {
	$("#user_update").submit(function() {
        if ($("#btn-update").prop("disabled", false)) { 
            alert("회원정보 수정이 완료되었습니다");
        } else {
        	$("#btn-update").prop("disabled", true);
			alert("작성한 내역을 다시 확인해주세요.");
				
		}
	})
		
	//아이디 유효성 검사
	$("#id").keyup(function() {
		var id = $("#id").val();
		var num = id.search(/[0-9]/g);
		var eng = id.search(/[a-z]/ig);
		var spe = id.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
		
		$.ajax({
			url : "check_id",
			type : "POST",
			data : {
				id : id,
				num : num,
				eng : eng,
				spe : spe
			},
			success : function(result) {
				if (result == 1) {
					$("#id_check").html("*중복된 아이디가 있습니다.").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else if (id == "" || id == null) {
					$("#id_check").html("*아이디를 입력해주세요.").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else if(id.length < 5 || id.length > 12) {
					$("#id_check").html("*아이디는 5자 이상 12자 이내로 입력해주세요").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else if(num < 0 || eng < 0) {
					$("#id_check").html("*영문과 숫자를 혼합하여 입력해주세요.").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else {
					$("#id_check").html("사용가능한 아이디 입니다.").css("color", "#808080");
					$("#btn-update").prop("disabled", false);
				}
			},
		})
	});
	
	//이메일 유효성 검사
	$("#email").keyup(function() {
		var email = $("#email").val();
		var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	
		$.ajax({
			url : "check_email",
			type : "POST",
			data : {
				email : email,
				emailPattern : emailPattern
			},
			success : function(result) {
				if (result == 1) {
					$("#email_check").html("*중복된 이메일이 있습니다.").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else if(email == "" || email == null) {
					$("#email_check").html("*이메일을 입력해주세요.").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else if (!emailPattern.test(email)) {
					$("#email_check").html("*이메일 형식에 맞춰 다시 입력해주세요.").css("color", "red");
					$("#btn-update").prop("disabled", true);
				} else {
					$("#email_check").html("사용가능한 이메일입니다.").css("color", "#808080");
					$("#btn-update").prop("disabled", false);
				}
			},
		})
	});
})

//주소 유효성 검사
function address_checkF(){
	var address_kakao = $("#address_kakao").val(); 
	var address_detail = $("#address_detail").val(); 
	
	if (address_kakao == "" || address_kakao == null) {
        $("#addr_msg").html("*주소를 입력해주세요.").css("color", "red");
        $("#btn-update").prop("disabled", true);
    } else {
        $("#addrK_msg").html("");
        $("#btn-update").prop("disabled", false);
    }
	if(address_detail == "" || address_detail == null) {
    	$("#addr_msg").html("*상세주소를 입력해주세요.").css("color", "red");
    	$("#btn-update").prop("disabled", true);
    }
    else {
        $("#addr_msg").html("");
        $("#btn-update").prop("disabled", false);
    }
}

//회원 정보 수정
function submitUpdate() {
	var email = document.getElementById("email").value;
    var pwd = document.getElementById('pwd').value;
    var repwd = document.getElementById('repwd').value;
    var phone = document.getElementById("phone").value;
    var name = document.getElementById("name").value;
    var theform = document.getElementById("user_update");
  
    if (pwd.length < 8 || pwd.length > 12) {
        alert("비밀번호는 8글자 이상, 12글자 이하만 이용 가능합니다.");
        pwd = "";
        return false;
    }
    if (name == "") {
        alert("이름을 입력하세요.");
        name.focus();
        return false;
    }
    if (name.search(/\s/) != -1) {
        alert("이름을 공백 없이 입력해주세요.");
        return false;
    }
    if (pwd.length <= 8 || pwd.length >= 12) {
        alert("비밀번호는 8글자 이상, 12글자 이하만 이용 가능합니다.");
        pwd = "";
        return false;
    }
    if (pwd.search(/\s/) != -1) {
        alert("비밀번호는 공백 없이 입력해주세요.");
        pwd = "";
        return false;
    }
    if (num < 0 || eng < 0 || spe < 0) {
        alert("영문, 숫자, 특수문자를 혼합하여 입력해주세요.");
        return false;
    }
    if (email.includes("<") || email.value.includes(">")) {
        alert("'<'와 '>' 문자를 사용할 수 없습니다.");
        return false;
    }
    if (email == "") {
        alert("이메일을 입력하세요.");
        email.focus();
        return false;
    }
    if (repwd == "") {
        alert("비밀번호를 확인해주세요.");
        repwd.focus();
        return false;
    }
    if (!emailPattern.test(email)) {
        alert("이메일을 다시 입력해주세요.");
        email.focus();
        return false;
    }
    if (email.search(/\s/) != -1) {
        alert("이메일을 공백 없이 입력해주세요.");
        return false;
    }
    if (phone == "") {
        alert("핸드폰번호를 입력하세요.");
        phone.focus();
        return false;
    }
    if (phone.length < 13 || phone.length > 14) {
        alert("전화번호를 다시 입력해주세요.");
        phone.focus();
        return false;
    }
    if (!phonePattern.test(phone)) {
        alert("전화번호는 숫자만 입력해주세요.");
        phone.focus();
        return false;
    }
    if (phone.search(/\s/) != -1) {
        alert("전화번호를 공백 없이 입력해주세요.");
        return false;
    }
    
    alert("회원 정보가 수정되었습니다.");
    theform.action = "userInfoUpdate";
    theform.submit();
}

//회원 탈퇴
function submitDelete() {
	//추후 주문내역 존재할 경우 탈퇴 시 주문내역 삭제하는 로직 작성
	if (confirm("정말로 탈퇴하시겠습니까?")) {
		deletepro();
	}
}
//회원탈퇴시 비밀번호 입력 프롬창
function deletepro() {
	var promptObj = prompt('회원 비밀번호를 입력하세요.', '');
	$.ajax({
		type : "POST",
		url : 'userInfoDelete',
		dataType : "text",
		contentType : 'application/x-www-form-urlencoded; charset=utf-8',
		data : {
			pwd : promptObj
		},
		success : function(data) {
			if (data === 'success') {
		        alert("탈퇴가 완료되었습니다. 감사합니다.");
		        location.href = 'index';
		    } else if (data === 'fail') {
		        alert("비밀번호를 틀렸습니다.");
		    } else {
				document.write(data);
			}
		},
		error : function(data) {
			if (data.status == 401) {
				alert('failed.');

				return;
			}
		}
	});
}