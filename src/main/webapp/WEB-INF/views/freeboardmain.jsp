<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판임니다.</title>
<script type="text/javascript">
	function forview(seq){
		var f = document.forView;
		f.board_seq.value= seq;
		f.action="freeboardview";
		f.method="post";
		f.submit();
	}
</script>
</head>
<body>
<h2>자유게시판</h2>
<form name="forView">
	<input type="hidden" name="board_seq">
</form>
<input type="button" value="글쓰기" onclick="location.href='freeboardwrite'">
<table>
	<tr>
		<td>
			<form action="freeboardsearchpage" method="get">
				<input type="hidden" name="page" value="${pvo.page }">
				<select name="searchtype">
					<option value="title" selected>제목</option>
					<option value="writerid">아이디</option>
					<option value="content">내용</option>
				</select>
				<input type="text" name="searchvalue" required="required">
				<input type="submit" value="찾기">
			</form>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
<c:choose>
	<c:when test="${list==null }">
	<tr>
		<td colspan="5">등록된 게시글이 없습니다.</td>
	</tr>
	</c:when>
	<c:otherwise>
		<c:forEach var="board" items="${notice }">
			<tr>
				<td>${board.board_seq }</td>
				<td><a href="javascript:forview('${board.board_seq }')">${board.title }</a></td>
				<%-- <td><a href="freeboardView?board_seq=${board.board_seq }">${board.title }</a></td> --%>
				<td>${board.writerid }</td>
				<td>${board.writedate }</td>
				<td>${board.board_hits }</td>
			</tr>
		</c:forEach>
		<c:forEach var="board" items="${list }">
			<tr>
				<td>${board.board_seq }</td>
				<td>${board.title }</td>
				<td>${board.writerid }</td>
				<td>${board.writedate }</td>
				<td>${board.board_hits }</td>
			</tr>
		</c:forEach>
	</c:otherwise>
</c:choose>

</table>

<table>
<tr>
<c:forEach var="num" begin="${pvo.pagestart }" end="${pvo.pageend }" step="1">
	<td><a href="freeboardmain?page=${num }
	<c:if test="${pvo.searchtype != null }">&searchtype=${pvo.searchtype }&searchvalue=${pvo.searchvalue }
	</c:if>">[${num}]</a></td>
	<%-- <c:if test="${pvo.searchtype != null }">&searchtype=${pvo.searchtype }&searchvalue=${pvo.searchvalue }</c:if> --%>
</c:forEach>
</tr>
</table>

</body>
</html>