<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
</head>
<body>
	<h2>투표하기</h2>
	<form action="${pageContext.request.contextPath }/vote/do" method="post">
	<table border ="1">
		<tr>
			<th>주민번호</th>
			<td>
				<input type="text" name="vjumin">
			</td>
		</tr>
		<tr>
			<th>성명</th>
			<td>
				<input type="text" name="vname">
			</td>
		</tr>
		<tr>
			<th>투표번호</th>
			<td>
				<input type="text" name="mno">
			</td>
		</tr>
		<tr>
			<th>투표시간</th>
			<td>
				<input type="text" name="vtime">
			</td>
		</tr>
		<tr>
			<th>투표장소</th>
			<td>
				<input type="text" name="varea">
			</td>
		</tr>
		<tr>
			<th>유권자확인</th>
			<td>
				<input type="radio" name="vconfirm" id="확인" value="Y">
				<input type="radio" name="vconfirm" id="미확인" value="N">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit" >투표하기</button>
				<button type="reset" >다시하기</button>
		</tr>
	</table>
	</form>
</body>
</html>