<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표 결과</title>
</head>

<body>
	<h2>투표 결과</h2>
	<div>
		<table border="1">
			<tr>
				<th>선거구명</th>
				<th>기호</th>
				<th>정당명</th>
				<th>성명</th>
				<th>성별</th>
				<th>생년월일(연령)</th>
				<th>학력</th>
				<th>득표수</th>
				<th>비고</th>
			</tr>
	<c:forEach items="${endList }" var="vo">
			<tr>
				<td>${vo.mcity }</td>
				<td>${vo.mno }</td>
				<td>${vo.pname }</td>
				<td>${vo.mname }</td>
				<td>${vo.gender }</td>
				<td>${vo.birth }</td>
				<td>${vo.gschoolName }</td>
				<td>${vo.cnt }</td>
				<c:choose>
					<c:when test="${vo.rank==1 }">
						<td>당선</td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				<%-- <td class="rnk">${vo.rank }</td> --%>
				</c:choose>
			</tr>
	</c:forEach>
		</table>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>

</body>

</html>