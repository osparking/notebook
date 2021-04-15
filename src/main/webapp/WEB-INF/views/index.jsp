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
</head>
<body>
	<h1>${ownerName}노트</h1>
	<p>${welcomMsg}</p>
	<form:form method="POST" modelAttribute="newMemo">
		<div>
			<label for="memoContent">메모 : </label>
			<form:textarea id="memoContent" path="content" rows="3" cols="50" />
			<input type="submit" id="btnAdd" value="저장" />
		</div>
	</form:form>
</body>
</html>