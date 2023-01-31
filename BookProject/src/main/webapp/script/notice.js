function writeCheck() {
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력해 주세요.");
		return false;
	}
	
	if (document.frm.content.value.length == 0) {
		alert("내용을 입력해 주세요.");
		return false;
	}
	var flag = confirm("등록하시겠습니까?");
    if (!flag) return false;
    return true;
}

function updateCheck() {
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력해 주세요.");
		return false;
	}
	
	if (document.frm.content.value.length == 0) {
		alert("내용을 입력해 주세요.");
		return false;
	}
	var flag = confirm("수정하시겠습니까?");
    if (!flag) return false;
    return true;
}

function deleteCheck() {
	var flag = confirm("삭제하시겠습니까?");
	if (flag) {
		alert("삭제되었습니다.");
		return true;
	}
	return false;
}