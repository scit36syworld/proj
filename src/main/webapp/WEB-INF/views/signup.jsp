<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
<script type="text/javascript">
	<c:if test="${msg!=null}">
	alert('${msg}');
	</c:if>

	var d = document;
	function changefocus(obj, param){
		if(obj.value.trim().length==0){
			if(param=='userpw'){
				d.getElementById('pwcheck').style.display = 'block';
				d.getElementById('userpw').focus();
			} else if(param=='username'){
				d.getElementById('namecheck').style.display = 'block';
				d.getElementById('username').focus();
			}
		} else {
			if(param=='userpw'){
				d.getElementById('pwcheck').style.display = 'none';
			} else if(param=='username'){
				d.getElementById('namecheck').style.display = 'none';
			}  
		}
	}
	
	function ispwsame(obj, param){
		if(d.getElementById('userpw').value ==d.getElementById('userpw2').value) {
			d.getElementById('pwcheck2').style.display = 'none';
			d.getElementById('pwcheck3').style.display = 'block';
		} else {
			d.getElementById('pwcheck2').style.display = 'block';
			d.getElementById('pwcheck3').style.display = 'none';
		}
	}
	
	function sendcheck(){
		if(d.getElementById('username').value==''){
			alert('이름을 입력해주세요');
			return false;
		}
	}
	
</script>

</head>
<body>
	<h1> Syworld</h1>
	<form action="signup" method="post" onsubmit="return sendcheck()">
	<table>
		<tr>
			<td>
				아이디<br>
				<input type="text" name="userid" id="userid" value="${uvo.userid }" placeholder="아이디 체크를 해주세요" readonly>
				<input type="button" value="아이디 체크" onclick="window.open('idCheck','idCheck', 'top=0, left=0, height=250, width=300')"><br>
				
			</td>
			<td>
			</td>
			
		</tr>
		<tr>
			<td>
				비밀번호<br>
				<input type="password" name="userpw" id="userpw" value="${uivo.userpw }" onblur="changefocus(this,'userpw')"><br>
				<div class="check" id="pwcheck" style="display:none">비밀번호를 입력해주세요. </div>
			</td>
			
		</tr>
		<tr>
			<td>
				비밀번호확인<br>
				<input type="password" name="userpw2" id="userpw2" onblur="ispwsame(this,'pw')">
				<div class="check" id="pwcheck2" style="display:none">비밀번호를 확인해주세요. </div>
				<div class="check" id="pwcheck3" style="display:none">사용가능 </div>
			</td>
		</tr>
		<tr>
			<td>
				이름
				<input type="text" name="username" id="username" value="${uivo.username }" onblur="changefocus(this,'username')"><br>
				<div class="check" id="namecheck" style="display:none">이름을 입력해주세요. </div>
			</td>
		</tr>
		<tr>
			<td>
				핸드폰번호 
				<input type="text" name="userphone" id="userphone" value="${uivo.userphone }">
			</td>
		</tr>
		<tr>
			<td>
				생년월일 
				<input type="date" name="userbirth" id="userbirth" value="${uivo.userbirth }">
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="가입하기">
				<input type="button" value="가입취소" onclick="location.href='./'">
			</td>
		</tr>
	
	</table>
	
	</form>

</body>
</html>