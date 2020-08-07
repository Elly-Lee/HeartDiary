<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
body, ul, li {
	margin: 50px;
	padding: 10px;
	list-style: none;
}

body {
	background-color : #E6E6FA;
}

textarea{ 
	width:500px;
	height:100px;
	resize:none;
}

</style>

<h1> 오늘 하루는 어떠셨나요</h1>

<form action="./doWrite" method="POST">
<input type="hidden" name="memberId" value="${member.id}"/>
	<div class="table-box con">
		<table>
			<tbody>
				<tr>
					<th>title</th>
					<td><input type="text" name="title" placeholder="제목을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>diary of today</th>
					<td><textarea name="body" placeholder="내용을 입력해주세요."></textarea>
					</td>
				</tr>
				<tr>
					<th>Upload</th>
					<td><input type="submit" value="작성" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</form>


<%@ include file="../part/foot.jspf"%> 