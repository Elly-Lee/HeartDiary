<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="로그인" />
<%@ include file="../part/head.jspf"%>
<h1 class="con">♥</h1>
<h2 class ="title con">H - Diary</h2>

<form action="./doLogin" method="POST">
	<div class="table-box con">
		<table>
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
	<table>
		<tbody>
			<tr>
				<th>you wanna join?</th>
				<br />
				<td><button type="button"
						onClick="location.href='/member/join'">Join</button></td>
			</tr>
		</tbody>
	</table>
</div>



<%@ include file="../part/foot.jspf"%> 