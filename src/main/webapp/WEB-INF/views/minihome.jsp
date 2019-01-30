<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>${mhvo.userid}님의 미니홈피입니다!</title>
<script>
	if (${msg != null }) {
		alert(msg);
	}
</script>
</head>
<body>

<!-- 
접속자 정보 table update는 controller 단에서 정리한다.

-->

<!-- 미니홈피 정보 보여주기 div -->
<div id="showminihome" style="width: 500px; height: 300px; background: #c8edb6">	
<c:if test="${mhvo == null}">해당 미니홈피가 없습니다.</c:if>
<c:if test="${mhvo != null}">
	<c:if test="${mhvo.privateFlag == 1}">비공개 미니홈피입니다.</c:if> 
	<c:if test="${mhvo.privateFlag == 0}">
			${mhvo.userid}님의 미니홈피입니다!
			<br>총 방문자수: ${mhvo.minihits }
			<br>사아아진: <img src="${mhvo.userphoto }" style="width: 100px; height: 100px;">
			<br>자기소개: <textarea style="width: 200px; height: 100px;">${mhvo.userprofile}</textarea>
	</c:if>
</c:if>
</div>

<!-- 최근 접속자 정보 보여주기 -->
<div id="recentVisitors" style="width: 500px; height: 250px; background: #839679">
	최근 접속자 정보: 
	<c:if test="${mhvo == null}"> 정보가 없습니다.</c:if>
	<c:if test="${mhvo != null}"> <c:forEach var="iter" items="${mhitvo}"><br> ${iter }	</c:forEach></c:if>
</div>
</body>
</html>
