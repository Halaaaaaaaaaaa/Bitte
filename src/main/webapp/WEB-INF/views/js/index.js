//로그아웃 처리
function logoutClicked() {
    var confirmed = confirm("로그아웃 하시겠습니까?");
    if (confirmed) {
    	alert("로그아웃 되었습니다.");
        window.location.href = "/logout";
    }
}

/* header menu close event
document.addEventListener("DOMContentLoaded", function() {
    const loginToggle = document.getElementById("toggle-login");
    const noticeToggle = document.getElementById("toggle-notice");
    const menuToggle = document.getElementById("toggle-menu");

    // 문서의 클릭 이벤트 감지
    document.addEventListener("click", function(event) {
        // 토글 박스 이외의 영역을 클릭했을 때
        if (!event.target.closest(".hamburger-login") ||
            !event.target.closest(".hamburger") ||
            !event.target.closest(".hamburger-alt")) {
            loginToggle.checked = false;
            noticeToggle.checked = false;
            menuToggle.checked = false;
        } 
    });

    // 토글 요소 클릭 시
    loginToggle.addEventListener("click", function(event) {
        event.stopPropagation(); // 이벤트 전파 방지
    });

    noticeToggle.addEventListener("click", function(event) {
        event.stopPropagation(); // 이벤트 전파 방지
    });

    menuToggle.addEventListener("click", function(event) {
        event.stopPropagation(); // 이벤트 전파 방지
    });
});
*/


