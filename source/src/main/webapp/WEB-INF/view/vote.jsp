<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script>
	window.onload = loadedHandler;
	function loadedHandler(){
		$("#doVOTE").click(regHandler);
		$("#resetVOTE").click(resetClickHandler);
	}
	
	function regHandler(){
		var vjumin = $("#vjumin").val();
		var regjumin = /[0-9]{13}/;
		if(!regjumin.test(vjumin)){
			alert("주민번호가 입력되지 않았습니다!");
			$("#vjumin").focus();
			return false;
		}
		var vname = $("#vname").val();
		var regvname = /[가-힣]{2,6}/;
		if(!regvname.test(vname)){
			alert("성명이 입력되지 않았습니다!");
			$("#vname").focus();
			return false;
		}
		var mno = $("#mno").val();
		console.log(mno);
		if(mno=="no" || mno==""){
			alert("후보번호가 선택되지 않았습니다!");
			$("#mno").focus();
			return false;
		}
		var vtime = $("#vtime").val();
		var regvtime = /^[00-23]{1}[00-59]{1}/;
		if(!regvtime.test(vtime)){
			alert("투표시간이 입력되지 않았습니다!");
			$("#vtime").focus();
			return false;
		}
		var varea = $("#varea").val();
		var regvarea = /제[1-2]투표장/;
		if(!regvarea.test(varea)){
			alert("투표장소가 입력되지 않았습니다!");
			$("#varea").focus();
			return false;
		}
		var vconfirm = $("[name=vconfirm]").val();
		/* if(vconfirm == "no" || vconfirm ==""){
			alert("유권자확인이 선택되지 않았습니다!");
			$("[name=vconfirm]").focus();
			return false; */
			if($("#xx").prop("checked")){
				alert("유권자확인이 선택되지 않았습니다!");
				$("[name=vconfirm]").focus();
				return false; 
		}
		alert("투표하기 정보가 정상적으로 등록 되었습니다!");
		
	}
	
	function resetClickHandler(){
		alert("정보를 지우고 처음부터 다시 입력합니다!");
		$("#vjumin").focus();
	}	
	
	
	
</script>
<style>
	#xx{
		display: none;
	}
</style>
</head>
<body>
	<h2>투표하기</h2>
	<form action="${pageContext.request.contextPath }/vote/do" method="post">
		<table border ="1">
			<tr>
				<th>주민번호</th>
				<td>
					<input type="text" name="vjumin" class="check" id="vjumin">
					예 : 1201011010101
				</td>
			</tr>
			<tr>
				<th>성명</th>
				<td>
					<input type="text" name="vname" class="check" id="vname">
				</td>
			</tr>
			<tr>
				<th>투표번호</th>
				<td>
					<select name="mno" class="check" id="mno">
						<option $("#mno").val() ="no"></option>
					<c:forEach items="${memberList }" var="member">
						<option value="${member.mno }">[${member.mno}] ${member.mname }</option>
						<!-- <option value="1">[1] 김후보</option>
						<option value="2">[2] 이후보</option>
						<option value="3">[3] 박후보</option>
						<option value="4">[4] 조후보</option>
						<option value="5">[5] 최후보</option> -->
					</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>투표시간</th>
				<td>
					<input type="text" name="vtime" class="check" id ="vtime">
				</td>
			</tr>
			<tr>
				<th>투표장소</th>
				<td>
					<input type="text" name="varea" class="check" id="varea">
				</td>
			</tr>
			<tr>
				<th>유권자확인</th>
				<td>
					<input type="radio" name="vconfirm" id="xx" value ="no" checked>
					<label for="xx"></label>
					<input type="radio" name="vconfirm" id="yy" value="Y">
					<label for="yy">확인</label>
					<input type="radio" name="vconfirm" id="nn" value="N">
					<label for="nn">미확인</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="submit" class="r" id="doVOTE">투표하기</button>
					<button type="reset" class="r" id="resetVOTE">다시하기</button>
			</tr>
		</table>
	</form>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
	
	
	
</body>
</html>