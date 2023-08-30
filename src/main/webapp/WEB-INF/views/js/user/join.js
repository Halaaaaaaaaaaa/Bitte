//전화번호 하이픈 자동 생성
function hypenTel(target) {
	const maxLength = 11; // 최대 글자 수

	let value = target.value.replace(/[^0-9]/g, '');
	value = value.substring(0, maxLength);

	target.value = value.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/, `$1-$2-$3`);
}