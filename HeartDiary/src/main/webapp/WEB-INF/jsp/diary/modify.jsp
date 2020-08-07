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
	background-color: #E6E6FA;
}

textarea {
	width: 500px;
	height: 100px;
	resize: none;
}
</style>

<form method="POST" action="./doModify">
	<input type="hidden" name="id" value="${diary.id}"/>
	<div class="table-box con">
		<table>
			<colgroup>
				<col width="180">
				<col>
			</colgroup>
			<tbody>
				<tr>
					<th>#</th>
					<td>${diary.id}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${diary.regDate}</td>
				</tr>
				<tr>
					<th>title</th>
					<td><input type="text" name="title" placeholder="제목을 수정해주세요."
						value="${diary.title}" /></td>
				</tr>
				<tr>
					<th>diary</th>
					<td><textarea name="body" placeholder="내용을 수정해주세요.">${diary.body}</textarea>
					</td>
				</tr>
				<tr>
					<th>수정</th>
					<td><input type="submit" value="수정" /></td>
				</tr>
			</tbody>
		</table>
	</div>
</form>


<%@ include file="../part/foot.jspf"%>
