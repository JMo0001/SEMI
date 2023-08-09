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
<title>투표검수조회</title>
</head>
<body>
<%@include file="/WEB-INF/view/header.jsp" %>
	<div class="section-wrap">
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
					<td>${vo.vname}</td>
					<td>${vo.vbirth }</td>
					<td>${vo.vage }</td>
					<td>${vo.gender }</td>
					<td>${vo.mno }</td>
					<td>${vo.vtime }</td>
					<td>${vo.vconfirm }</td>
				</tr>
			</c:forEach>
			</table>
		</div>
		<div>
		<c:if test="${startPageNum != 1 }">
					<a href="${pageContext.request.contextPath }/vote/check?pageNo=${startPageNum-1}" >
					<span>이전</span></a>
		</c:if>
		<c:forEach begin="${startPageNum }" end="${endPageNum }" var="i">
					<a href="${pageContext.request.contextPath }/vote/check?pageNo=${i}">
					<span>${i }</span></a>
		</c:forEach>
		<c:if test="${endPageNum < totalPageNum }">
					<a href="${pageContext.request.contextPath }/vote/check?pageNo=${endPageNum+1}">
					<span>다음</span></a>
		</c:if>
		</div>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
<%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>