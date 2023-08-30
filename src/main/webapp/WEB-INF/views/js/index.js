//로그아웃 처리
function logoutClicked() {
    var confirmed = confirm("로그아웃 하시겠습니까?");
    if (confirmed) {
        window.location.href = "/logout"; // 로그아웃 처리 URL로 이동
    }
}