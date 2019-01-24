<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<script type="text/javascript">
<c:if test="${msg !=null}">
	alert("${msg}");
</c:if>
	function idcheck(){
		var id = document.getElementById("userid").value;
		if(id==''){
			alert('아이디를 입력해주세요');
			return false;
		}
		
		return true;
	}
</script>

</head>
<body>
	<h2>아이디 중복 확인</h2>
	<form action="idChecker" method="post" onsubmit="return idcheck()">
		<p><input type="text" name="userid" id="userid" value="${userid }" placeholder="아이디를 입력해주세요">
			<input type="submit" value="중복확인">
		</p>
	</form>
	<c:if test="${result !=null }">
		<c:if test="${result==true }">
			<script type="text/javascript">
				function send(){
					opener.document.getElementById("userid").value = document.getElementById("userid").value;
					window.close();
				}
			</script>
			
			사용 가능한 아이디 입니다.
			<input type="button" value="사용하기" onclick="send()">
		</c:if>
	</c:if>
	<input type="button" value="취소" onclick="window.close()">

	
</body>
</html>