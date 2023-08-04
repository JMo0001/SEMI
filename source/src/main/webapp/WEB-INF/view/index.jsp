<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 메인페이지</title>
</head>
<body>
	<h2>메인페이지</h2>
	<nav>
		<a href="${pageContext.request.contextPath }/member/list">후보조회</a>
	</nav>
	<nav>
		<a href="${pageContext.request.contextPath }/vote/do">투표하기</a>
	</nav>
	<nav>
		<a href="${pageContext.request.contextPath }/vote/check">투표검수조회</a>
	</nav>
	<nav>
		<a href="${pageContext.request.contextPath }/end">투표결과조회</a>
	</nav>
	<nav>
		<a href="${pageContext.request.contextPath }/row" >후보자등수조회</a>
	</nav>
</body>
</html>