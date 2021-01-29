<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
tr.row:hover {
	background-color: lightblue
}
;
</style>
<script type="text/javascript">
	function formSubmit(str){
	frm.bId.value=str;
	frm.submit();
}
</script>
</head>
<body>
	<div align="center">
		<div>
			<h1>게시글 목록</h1>
			<div>
				<form id="frm" name="frm" action="boardView.do" method="post">
				<input type="hidden" id="bId" name="bId"></form>
			</div>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="50">글 번호</th>
					<th width="150">제목</th>
					<th width="100">작성자</th>
					<th width="100">작성일자</th>
					<th width="50">조회수</th>
				</tr>
				<c:if test="${empty list }">
					<tr>
						<td align="center" colspan="5">게시글이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty list }">
					<c:forEach var="vo" items="${list }">
						<tr class="row" onclick="formSubmit(${vo.bId})">
							<td align="center">${vo.bId }</td>
							<td>&nbsp;${vo.bTitle }</td>
							<td align="center">${vo.bName }</td>
							<td align="center">${vo.bDate }</td>
							<td align="center">${vo.bHit }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		<br />
		<div>
			<button type="button" onclick="location.href='boardForm.do'">새글작성</button>
		</div>
	</div>
</body>
</html>