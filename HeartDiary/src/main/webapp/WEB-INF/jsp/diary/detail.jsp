<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../part/head.jspf"%>
 <!-- Style -->
<style>
body, ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	background-color : #E6E6FA;
}

h1 {
	margin-left : 100px;
	margin-top : 30px;
}


table {
	width: 85%;
	margin-left : 100px;
	border : solid white;
}
tbody {
	margin-left: 50px;
}
th, td {
	padding : 5px;
}

a {
	text-decoration: none;
	color: red;
}
</style>

<h1 class="head"> 오늘의 일기 <a style="color:grey; text-decoration:none; font-size: 15px " href="/diary/list">뒤로가기</a></h1>


<div class="table">
	<table>
		<colgroup>
			<col width="80">
			<col>
			<col width="80">
			<col width="200">
			<col width="80">
		</colgroup>
		<tbody>
			<tr>
				<th>#</th>
				<td>${diary.id}</td>
			</tr>
			<tr>
				<th>Date</th>
				<td>${diary.regDate}</td>
			</tr>
			<tr>
				<th>Title</th>
				<td>${diary.title}</td>
			</tr>
			<tr>
				<th>Today</th>
				<td>${diary.body}</td>
			</tr>
			<tr>
				<th>#</th>
				<td>
				<a href="./modify?id=${diary.id}" > 수정 </a>
				<a href="./doDelete?id=${diary.id}" onclick="if ( confirm('삭제하시겠습니까?') == false ) { return false; }"> 삭제 </a></td>
			</tr>
		</tbody>
	</table>
</div>




<%@ include file="../part/foot.jspf"%> 