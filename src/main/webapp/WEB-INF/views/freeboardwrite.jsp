<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	
	function sendcheck(){
		if(document.getElementById('boardname').value==""){
			alert('게시판을 선택해주세요');
			return false;
		} else if(document.getElementById('title').value==""){
			alert('제목을 입력해주세요');
			return false;
		} else if(document.getElementById('content').value==""){
			alert('내용을 입력해주세요');
			return false;
		}
		return true;
	}
</script>
</head>
<body>

  <form action="gofreeboardwrite" method="post" enctype="multipart/form-data" onsubmit="return sendcheck()">
  
	<input type="hidden" name="writerid" value="${loginid }"><br>
    <select name="boardname" id="boardname">
		<option value="" selected>게시판 선택</option>
		<option value="notice">공지</option>
		<option value="freeboard" >자유게시판</option>
	</select>
	  제목<input type="text" name="title" id="title"><br>
	<input type="text" name="content" id="content" placeholder="내용을 입력해주세요." style="text-align:center; width:350px; height:500px;"><br>
	<input type="file" name="upload"><br>
    <input type="submit" value="완료">
    <input type="button" value="취소" onclick="location.href='./freeboardmain'">
  </form>


</body>
</html>