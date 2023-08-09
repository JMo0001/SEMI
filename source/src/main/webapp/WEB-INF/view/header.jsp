<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
	<div class = "h">
		<h2>SEMI - 지역구의원투표</h2>
	</div>
	<div class ="nav-container">
		<nav>
			<ul>
				<li>
					<a href="${pageContext.request.contextPath }/member/list">후보조회</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/vote/do">투표하기</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/vote/check">투표검수조회</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/end">투표결과조회</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/row" >후보자득표수조회</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/index" >홈으로</a>
				</li>
			</ul>
		</nav>
	</div>
</header>