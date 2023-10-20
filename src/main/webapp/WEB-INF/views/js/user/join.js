//비밀번호 유효성 검사
function pwd_checkF(){
	var pwd = $("#pwd").val();
	var repwd = $("#repwd").val();
	var num = pwd.search(/[0-9]/g);
	var eng = pwd.search(/[a-z]/ig);
	var spe = pwd.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
	
	if(pwd == "" || pwd == null) {
		$("#pwd_msg").html("*비밀번호를 입력해주세요.").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else if(pwd.search(/\s/) != -1){
		$("#pwd_msg").html("*비밀번호는 공백 없이 입력해주세요.").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else if(num < 0 || eng < 0 || spe < 0){
		$("#pwd_msg").html("*영문,숫자,특수문자를 혼합하여 입력해주세요.").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else if(pwd.length < 8 || pwd.length > 16) {
		$("#pwd_msg").html("*비밀번호는 8자 이상 16자 이내로 입력해주세요").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else if(repwd == "" || repwd == null) {
		$("#repwd_msg").html("*비밀번호를 확인해주세요.").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else {
		$("#pwd_msg").html("");
		$("#joinBtn").prop("disabled", false);
	} 
	if(pwd != repwd){
		$("#repwd_msg").html("*비밀번호가 일치하지 않습니다.").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else {
		$("#repwd_msg").html("");
		$("#joinBtn").prop("disabled", false);
	}
}

//이름 유효성 검사
function name_checkF(){
	var name = $("#name").val();
	
	if (name == "" || name == null) {
		$("#name_msg").html("*이름을 입력해주세요.").css("color", "red");
		$("#joinBtn").prop("disabled", true);
	} else if (name.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?0-9]/gi) !== -1) { 
	    $("#name_msg").html("*이름을 올바로 입력해주세요.").css("color", "red");
	    $("#joinBtn").prop("disabled", true);
	} else if (name.length < 2) { 
	    $("#name_msg").html("*이름을 올바로 입력해주세요.").css("color", "red");
	    $("#joinBtn").prop("disabled", true);
	} else {
		$("#name_msg").html("");
		$("#joinBtn").prop("disabled", false);
	}
}

//휴대폰 유효성 검사
function phone_checkF(){
	var phone = $("#phone").val(); 
	
	if (phone == "" || phone == null) {
        $("#phone_msg").html("*핸드폰 번호를 입력해주세요.").css("color", "red");
        $("#joinBtn").prop("disabled", true);
    } else {
        $("#phone_msg").html("");
        $("#joinBtn").prop("disabled", false);
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
	$("#join").submit(function() {
        if ($("#joinBtn").prop("disabled", false)) { // joinBtn이 비활성화된 경우
            alert("회원가입이 완료되었습니다");
        } else {
        	$("#joinBtn").prop("disabled", true);
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
					$("#joinBtn").prop("disabled", true);
				} else if (id == "" || id == null) {
					$("#id_check").html("*아이디를 입력해주세요.").css("color", "red");
					$("#joinBtn").prop("disabled", true);
				} else if(id.length < 5 || id.length > 12) {
					$("#id_check").html("*아이디는 5자 이상 12자 이내로 입력해주세요").css("color", "red");
					$("#joinBtn").prop("disabled", true);
				} else if(num < 0 || eng < 0) {
					$("#id_check").html("*영문과 숫자를 혼합하여 입력해주세요.").css("color", "red");
					$("#joinBtn").prop("disabled", true);
				} else {
					$("#id_check").html("사용가능한 아이디 입니다.").css("color", "#808080");
					$("#joinBtn").prop("disabled", false);
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
					$("#joinBtn").prop("disabled", true);
				} else if(email == "" || email == null) {
					$("#email_check").html("*이메일을 입력해주세요.").css("color", "red");
					$("#joinBtn").prop("disabled", true);
				} else if (!emailPattern.test(email)) {
					$("#email_check").html("*이메일 형식에 맞춰 다시 입력해주세요.").css("color", "red");
					$("#joinBtn").prop("disabled", true);
				} else {
					$("#email_check").html("사용가능한 이메일입니다.").css("color", "#808080");
					$("#joinBtn").prop("disabled", false);
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
        $("#addrK_msg").html("*주소를 입력해주세요.").css("color", "red");
        $("#joinBtn").prop("disabled", true);
    } else {
        $("#addrK_msg").html("");
        $("#joinBtn").prop("disabled", false);
    }
	if(address_detail == "" || address_detail == null) {
    	$("#addrD_msg").html("*상세주소를 입력해주세요.").css("color", "red");
    	$("#joinBtn").prop("disabled", true);
    }
    else {
        $("#addrD_msg").html("");
        $("#joinBtn").prop("disabled", false);
    }
}