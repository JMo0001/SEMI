<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="${pageContext.request.contextPath }/resources/css/header.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/section.css" rel="stylesheet">
<link href="${pageContext.request.contextPath }/resources/css/footer.css" rel="stylesheet">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보 조회</title>
<style>

</style>
</head>
<body>
<%@include file="/WEB-INF/view/header.jsp" %>
<section>
	<div class="section-wrap">
		<h2>후보 조회</h2>
		<div>
			<table border='1'>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>
				<c:forEach items="${memberList }" var="vo">
				<tr>
					<td>${vo.mno }</td>
					<td>${vo.mname }</td>
					<td>${vo.pname }</td>
					<td>${vo.pschool }</td>
					<td>${vo.mjumin }</td>
					<td>${vo.mcity }</td>
					<td>${vo.tel }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
</section>
<%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>