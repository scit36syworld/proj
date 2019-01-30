<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	div#wrapper{
		width : 800px;
		margin : 0 auto;
	}
	div#wrapper>h2 {
		text-align : center;
	}
	div#wrapper table {
		margin:0 auto;
		width : 800px;
	}
	th {
		width: 100px;
	}
	pre {
		width : 600px;
		height : 200px;
		overflow: auto;
	}
	table.reply {
		width : 800px;
	}
	input[name='text'] {
		width : 600px;
	}
	span {
		display: inline-block;

		margin : 5px;
	}
	td.replycontent {
		width : auto;
	}
	td.replytext {
		width : 600px;
		text-align : left;
	}
	td.replysub {
		width : 80px;
		text-align : right;
	}
	td.replybtn{
		width : 100px;
		text-align : right;
	}
</style>
<script>
<c:if test="${msg!=null}"> alert('${msg}');</c:if>

function reply(idnum){
	var dis = document.getElementById('comment'+idnum).style.display
	if(dis == 'none'){
	document.getElementById('comment'+idnum).style.display = 'block';
	document.getElementById('button'+idnum).value = '접기';
	} else {
	document.getElementById('comment'+idnum).style.display = 'none';
	document.getElementById('button'+idnum).value = '댓글달기';
	}
}
	
</script>
</head>
<body>
<div id="wrapper">
<h2>[ 게시판 글보기 ]</h2>


<table border="1">
	<tr>
		<th>제목</th>
		<td>${fvo.title}</td>
	</tr>
	<tr>
		<th>글 쓴날</th>
		<td>${fvo.writedate}</td>
	</tr>	
	<tr>
		<th>글 쓴이</th>
		<td>${fvo.writerid}</td>
	</tr>
	<tr>
		<th>첨부 파일</th>
		<td>
			예정
		</td>
	</tr>
	<tr>
		<th>글내용</th>
		<td>
			<pre>${fvo.content}</pre>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
				<input type="button" value="글수정" onclick="location.href='boardfix?boardnum=${fvo.board_seq}'"/>
				<input type="button" value="글삭제" onclick="location.href='boarddelete?boardnum=${fvo.board_seq}'"/>
			<a href="./freeboardmain" >목록으로</a>
		</td>
	</tr>
</table>
<br />

<!-- 댓글 입력 -->
<table>
	<tr>
		<th>댓글</th>
		<td>
			<form action="freeBoardComment" method="post">
				<input type="hidden" name="board_seq" value="${fvo.board_seq }">
				<input type="hidden" name="writerid" value="${loginid }">
				<input type="text" name="content"><input type="submit" value="댓글쓰기">
			</form>
		</td>
	</tr>
<!-- 댓글 출력 -->
	<c:if test="${!empty replylist }">
		<c:forEach var="comment" items="${commentlist }">
			<tr>
				<c:if test="${!empty comment.parentseq }">
					<td>ㄴ</td>
				</c:if>
				<td>${comment.writerid }</td>
				<td>${comment.content }</td>
				<td>${comment.writedate }</td>
				<c:if test="${empty comment.parentseq }">
					<td><input type="button" id="button${comment.boardcomments_seq }"value="댓글달기" onclick="reply('${comment.boardcomments_seq }')"></td>
				</c:if>
			</tr>
			<tr class="comment" id="comment${comment.boardcomments_seq }" style="display:none">
				<td>
					<form action="freeBoardComment" method="post">
						<input type="hidden" name="parentseq" value="${comment.boardcomments_seq }">
						<input type="hidden" name="board_seq" value="${fvo.board_seq }">
						<input type="hidden" name="writerid" value="${loginid }">
						<input type="text" name="content"><input type="submit" value="댓글쓰기">
					</form>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

</body>
</html>