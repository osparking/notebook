<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ownerName}</title>
<style>
textarea {
	vertical-align: top;
}
</style>
<style>
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
}

.table {
	
}
</style>
</head>
<body>
	<h1>${ownerName}노트</h1>
	<p>${welcomMsg}</p>
	<c:if test="${delCount eq 1}">메모 "${delSeqNo}"번 삭제됨</c:if>
	<form:form method="POST" modelAttribute="newMemo"
		onsubmit="return checkContent()">
		<div>
			<label for="memoContent">메모 : </label>
			<form:textarea id="memoContent" path="content" rows="3" cols="50" />
			<input type="submit" id="btnAdd" value="저장" />
		</div>
		<hr>
		<div>
			<table>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>연산1</th>
				</tr>
				<c:forEach items="${memo_list}" var="a_memo">
					<c:url var="deleteLink" value="/deleteMemo">
						<c:param name="seqNo" value="${a_memo.seqNo}" />
					</c:url>
					<tr>
						<td>${a_memo.seqNo}</td>
						<td>${a_memo.content}</td>
						<td><a href="${deleteLink}"
							onclick="if (!(confirm('정말 ' + ${a_memo.seqNo} + '번글을 삭제하겠습니까?'))) return false;">
								삭제
								</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form:form>
	<script type="text/javascript">
	function memoDelete(seqNo) {
		if (!(confirm('정말 ' + seqNo + '번글을 삭제하겠습니까?'))) return false;
	}
	function checkContent() {
		if (document.getElementById("memoContent").value.trim() == '')
			{
				alert("내용이 있어야 저장 가능합니다.");
				return false;
			}
	}
	</script>
</body>
</html>