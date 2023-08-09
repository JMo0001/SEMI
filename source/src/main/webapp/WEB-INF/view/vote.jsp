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
<title>투표하기</title>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script>
	window.onload = loadedHandler;
	function loadedHandler(){
		$("#doVOTE").click(regHandler);
		$("#doRESET").click(resetClickHandler);
	}
	
	function regHandler(){
		
		var vjumin = $("#vjumin").val();
		var regjumin = /^[0-9]{13}$/;
		if(vjumin==""){
			alert("주민번호를 입력해 주세요.");
			$("#vjumin").focus();
			return false;
		}else if(!regjumin.test(vjumin)){
			alert("주민번호가 올바르지 않습니다!");
			$("#vjumin").focus();
			return false;
		}
		
		var vname = $("#vname").val();
		var regvname = /^[가-힣]{2,6}$/;
		if($("#vname").val()==""){
			alert("성명을 입력해 주세요.");
			$("#vname").focus();
			return false;
		}else if(!regvname.test(vname)){
			alert("성명이 올바르지 않습니다!");
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
		var regvtime = /^[0-2][0-9][0-5][0-9]$/;
		if($("#vtime").val()==""){
			alert("투표시간을 입력해 주세요."); 
			$("#vtime").focus();
			return false;
		}else if(!regvtime.test(vtime)){
			alert("투표시간이 올바르지 않습니다!");
			$("#vtime").focus();
			return false;
		}
		
		var varea = $("#varea").val();
		var regvarea = /^제[1-2]투표장$/;
		if(varea == ""){
			alert("투표장소를 입력해 주세요.");
			$("#varea").focus();
			return false;
		}else if(!regvarea.test(varea)){
			alert("투표장소가 올바르지 않습니다!");
			$("#varea").focus();
			return false;
		}
		
		var vconfirm = $("[name=vconfirm]:checked").val();
		/* if(vconfirm == "no" || vconfirm ==""){
			alert("유권자확인이 선택되지 않았습니다!");
			$("[name=vconfirm]").focus();
			return false; */
			if(vconfirm == 'no'){
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
<%@include file="/WEB-INF/view/header.jsp" %>
<section>
	<div class="section-wrap">
		<h2>투표하기</h2>
		<form action="${pageContext.request.contextPath }/vote/do" method="post">
			<table border ="1">
				<tr>
					<th>주민번호</th>
					<td class="left">
						<input type="text" name="vjumin" class="check" id="vjumin">
						예 : 1201011010101
					</td>
				</tr>
				<tr>
					<th>성명</th>
					<td class="left">
						<input type="text" name="vname" class="check" id="vname">
					</td>
				</tr>
				<tr>
					<th>투표번호</th>
					<td class="left">
						<select name="mno" class="check" id="mno">
							<option value ="no"></option>
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
					<td class="left">
						<input type="text" name="vtime" class="check" id ="vtime">
					</td>
				</tr>
				<tr>
					<th>투표장소</th>
					<td class="left">
						<input type="text" name="varea" class="check" id="varea">
					</td>
				</tr>
				<tr>
					<th>유권자확인</th>
					<td class="left">
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
						<button type="reset" class="r" id="doRESET">다시하기</button>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<a href="${pageContext.request.contextPath }/index" >메인페이지로 돌아가기</a>
	</div>
</section>
<%@include file="/WEB-INF/view/footer.jsp" %>
</body>
</html>