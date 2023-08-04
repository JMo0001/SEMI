<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표검수조회</title>
</head>
<body>
	<h2>투표검수조회</h2>
	<div>
		<table border="1">
			<tr>
				<th>성명</th>
				<th>생년월일</th>
				<th>나이</th>
				<th>성별</th>
				<th>후보번호</th>
				<th>투표시간</th>
				<th>유권자확인</th>
			</tr>
		<c:forEach items="${checkList}" var="vo">
			<tr>
				<th>${vo.vname}</th>
				<th>${vo.vbirth }</th>
				<th>${vo.vage }</th>
				<th>${vo.gender }</th>
				<th>${vo.mno }</th>
				<th>${vo.vtime }</th>
				<th>${vo.vconfirm }</th>
			</tr>
		</c:forEach>
		</table>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
</body>
</html>