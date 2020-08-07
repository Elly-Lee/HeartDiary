<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../part/head.jspf"%>
<style>
	body, ul, li {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	background-color : #E6E6FA;
}
.table-box1>table {
	margin-left : 100px;
	width: 70%;
	border-collapse: collapse;
}

.table-box1>table td, .table-box1>table th {
	padding: 8px;
	border: 1px solid white;
	
}


.height-100px {
	height: 100px;
}

.height-200px {
	height: 200px;
}

.margin-top-30 {
	margin-top:30px;
}

.text-align-center {
	text-align:center;
}

.table-box>table {
	width: 100%;
	border-collapse: collapse;
}

h1 {
	margin-left : 100px;
}
</style>

<h1 class="t1 margin-top-30">Diaries</h1>

<div class="table-box1 con">
	<table>
		<colgroup>
			<col width="80">
			<col width="200">
			<col width="350">
			<col width="200">
		</colgroup>
		<thead>
			<tr>
				<th>#</th>
				<th>Date</th>
				<th>Diary</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${diaries}" var="diary">
				<tr>
					<td>${diary.id}</td>
					<td>${diary.regDate}</td>
					<td><a style="color:black; text-decoration: none;" href="./detail?id=${diary.id}">${diary.title}</a></td>
					<td><a style="color:red; text-decoration: none;" href="/diary/doDelete?id=${diary.id}" onclick="if ( confirm('삭제하시겠습니까?') == false ) { return false; }"> 삭제 </a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<%@ include file="../part/foot.jspf"%> 