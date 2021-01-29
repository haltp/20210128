<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<script type="text/javascript">
	function deleteAlert() {
		var yn = confirm("정말 삭제하시겠습니까?");
		if(yn) {
			frm.action.value="boardDelete.do";
			frm.submit();
		}
	}
	
	function editAlert() {
		frm.action.value="boardEditForm.do";
		frm.submit();
	}
</script>
</head>
<body>
	<div align="center">
		<table border="1">
			<tr>
				<th width="100">작성자</th>
				<td width="120" align="center">${vo.bName }</td>
				<th width="100">작성일자</th>
				<td width="120" align="center">${vo.bDate }</td>
				<th width="100">조회수</th>
				<td width="100" align="center">${vo.bHit }</td>
			</tr>
			<tr>
				<th width="50">제 목</th>
				<td colspan="5">${vo.bTitle }</td>
			</tr>
			<tr>
				<th width="50">내용</th>
				<td colspan="5"><textarea id="bcontent" name="bcontent"
						rows="7" cols="90">${vo.bContent }</textarea></td>
			</tr>
		</table>
		<br />
		<div>
			<button type="button" onclick="editAlert()">수정</button>
			&nbsp;&nbsp;
			<button type="button" onclick="deleteAlert()">삭제</button>
			&nbsp;&nbsp;
			<button type="button" onclick="location.href='boardList.do'">목록</button>
		</div>
		</div>
		<div>
			<form id="frm" name="frm" method="post">
				<input type="hidden" id="bId" name="bId" value="${vo.bId}">
			</form>
	</div>
</body>
</html>