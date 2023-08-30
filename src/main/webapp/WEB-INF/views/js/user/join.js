//전화번호 하이픈 자동 생성
function hypenTel(target) {
	const maxLength = 11; // 최대 글자 수

	let value = target.value.replace(/[^0-9]/g, '');
	value = value.substring(0, maxLength);

	target.value = value.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}

$(function() {
	$("#join").submit(
			function() {
				if ($("#pwd").val() !== $("#repwd").val()) {
					$("#id_check").html("비밀번호가 일치하지 않습니다.");
					$("#pwd").val("").focus();
					$("#repwd").val("");
					return false;
				} else if ($("#pwd").val().length < 8) {
					alert("비밀번호는 8자 이상으로 설정해야 합니다.");
					$("#pwd").val("").focus();
					return false;
				} else if ($.trim($("#pwd").val()) !== $("#pwd").val()
						|| $.trim($("#email").val()) !== $("#email").val()
						|| $.trim($("#id").val()) !== $("#id").val()) {
					alert("공백은 입력이 불가능합니다.");
					return false;
				}
			})

	$("#id").keyup(function() {
		$.ajax({
			url : "check_id",
			type : "POST",
			data : {
				id : $("#id").val()
			},
			success : function(result) {
				if (result == 1) {
					$("#id_check").html("중복된 아이디가 있습니다.");
					$("#joinBtn").attr("disabled", "disabled");
				} else {
					$("#id_check").html("사용가능한 아이디 입니다.");
					$("#joinBtn").removeAttr("disabled");
				}
			},
		})
	});

	$("#email").keyup(function() {
		$.ajax({
			url : "check_email",
			type : "POST",
			data : {
				email : $("#email").val()
			},
			success : function(result) {
				if (result == 1) {
					$("#email_check").html("중복된 이메일이 있습니다.");
				} else {
					$("#email_check").html("사용가능한 이메일입니다.");
				}
			},
		})
	});
})

function passwordCheckFunction(){
		var pwd = $("#pwd").val();
		var repwd = $("#repwd").val();
		if(pwd != repwd){
			$("#repwd_check").html("비밀번호가 일치하지 않습니다.");
		} else {
			$("#repwd_check").html("비밀번호가 일치합니다.");
		}
	}
