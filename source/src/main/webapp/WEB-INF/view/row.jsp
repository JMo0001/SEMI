<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자 득표 내역</title>
</head>
<body>
<c:choose>
<c:when test="${rowList != null }">
	<h2>득표 내역</h2>
	<div>
		<table border="1">
			<tr>
				<th>기호</th>
				<th>성명</th>
				<th>득표수</th>
			</tr>
			<tr>
				<td>${rowList.mno }</td>
				<td>${rowList.mname }</td>
				<td>${rowList.cnt }</td>
			</tr>
		</table>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
</c:when>
<c:otherwise>
	<h2>후보자 번호로 검색하기</h2>
	<div>
		<form action="${pageContext.request.contextPath }/row" method="get">
			<input type="text" name="mno" placeholder="번호를 입력하세요 (11~)">
			<button type="submit">조회하기</button>
		</form>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
</c:otherwise>
</c:choose>
</body>
</html>