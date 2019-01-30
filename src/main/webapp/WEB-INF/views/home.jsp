<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
	
<h1>
	Syworld!<br>
</h1>
<c:choose>
	<c:when test="${loginid!=null }">
	${loginname }님 환영합니다.
	<input type="button" value="logout" onclick="location.href='logout'">
	</c:when>
	<c:otherwise>
	<form action="login" method="post">
		<table>
			<tr>
				<td>ID <input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>PW<input type="password" name="userpw"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
			</tr>
		</table>
		<input type="button" value="회원가입" onclick="location.href='signup'">
	</form>
	</c:otherwise>
</c:choose>
<a href="freeboardmain"> 자유게시판으로</a>
<h1>test place here</h1>
<a href="minihome">minihome으로</a>

</body>
</html>
