<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/2022-04-25/member/controller" method="post">
		<h3>회원 가입</h3>
		<div>
			<label>아이디 :</label><input type="text" name="id" placeholder="아이디"> 
		</div>
	
		<div>	
			<label>비밀번호 :</label><input type="password" name="pw" placeholder="비밀번호"> 
		</div>
	
		<div>
			<label>이름 :</label><input type="text" name="name" placeholder="이름"> 
		</div>
	
		<input type="submit" value="회원가입">
	</form>
</body>
</html>