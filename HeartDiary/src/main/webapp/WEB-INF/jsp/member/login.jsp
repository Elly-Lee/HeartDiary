<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="로그인" />

<%@ include file="../part/head.jspf"%>
<style>
body, ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	background-color : #E6E6FA;
	text-align:center;
}

main  {
	text-align:center;
	
}



</style>

<h1 class="con">♥</h1>
<h2 class ="title con">H - Diary</h2>

<form action="./doLogin" method="POST">
	<div>
		<table style="margin: 0 auto;">
			<tbody>
				<tr>
					<td><input type="text" name="loginId" placeholder="ID 입력해주세요"
						autofocus="autofocus" /></td>
				</tr>
				<tr>
					<td><input type="password" name="loginPw"
						placeholder="PASSWORD 입력해주세요" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="→"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</form>

<div class="j">
	<table style="margin: 0 auto;">
		<tbody>
			<tr>
				<th>아직 회원이 아니신가요?</th>
				<br />
				<td><button type="button"
						onClick="location.href='/member/join'">가입할래요</button></td>
			</tr>
		</tbody>
	</table>
</div>



<%@ include file="../part/foot.jspf"%> 