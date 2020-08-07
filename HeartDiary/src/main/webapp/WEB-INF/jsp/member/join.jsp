<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pageName" value="로그인" />


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

h1 {
	color:white;
	background-color: #333;
	padding: 30px;
	display:block;
}

td {
	padding: 10px;
}

</style>


<h1 class="con">H - Diary 회원가입 </h1>


<form id="join__form" name="join" action="doJoin">
	<div class="table-box con">
		<table style="margin: 0 auto;">
			<tbody>
				<tr style="padding: 10px;">
					<th>ID</th>
					<td><input type="text" id="loginId" name="loginId"
						placeholder="아이디를 입력해주세요." autofocus="autofocus" /></td>
						<td><input type="button" id="idCheck" value="중복체크"></td>
				</tr>
				<tr>
					<td colspan=3 id="idCheck2"></td>
				</tr>
				<tr>
					<th>PASSWORD</th>
					<td><input type="password" id="loginPw" name="loginPw"
						placeholder="비밀번호를 입력해주세요." /></td>
				</tr>
				<tr>
					<th>NICKNAME</th>
					<td><input type="text" name="nickName" placeholder="닉네임을 입력해주세요." /></td>
				</tr>
				<tr>
					<th>회원가입</th>
					<td><input type="button" id="doJoin" value="JOIN"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</form>

<script type="text/javascript">
$(document).ready(function(e){
	
	var idx = false;
	
	$('#doJoin').click(function(){
		if($.trim($('#loginId').val()) == ''){
			alert("아이디 입력하세요.");
			$('#loginId').focus();
			return;
		}else if($.trim($('#loginPw').val()) == ''){
			alert("패스워드 입력.");
			$('#loginPw').focus();
			return;
		}
		
		if(idx==false){
			alert("아이디 중복체크를 해주세요.");
			return;
		}else{
			$('#join__form').submit();
		}
	});
	
	$('#idCheck').click(function(){
		$.ajax({
			url: '/member/idCheck',
			type: "GET",
			data:{
				"loginId":$('#loginId').val()
			},
			success: function(data){
				console.log('data ' + data.msg);
				console.log('data ' + data.success);
				var jsonData = JSON.stringify(data);
				console.log('jsonData ' + jsonData);

				if (data.success == false) {
					//console.log('성공이야 ');
					idx=true;
					//$('#loginId').attr("readonly", true);
					var html="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
					$('#idCheck2').empty();
					$('#idCheck2').append(html);
				} else {
					//console.log('실패 ');
					var html="<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
					$('#idCheck2').empty();
					$('#idCheck2').append(html);
				}				
			},
			error: function(){
				alert("서버에러");
			}
		});
	});
	
});
</script>


<%@ include file="../part/foot.jspf"%> 