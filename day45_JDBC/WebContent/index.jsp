<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Transfer" method="post">
	金额:<input type="text" name="num"/><br>
	输出:<input type="text" name="out"/><br>
	输入:<input type="text" name="put"/><br>
	<input type="submit" value="转账"/>
</form>
</body>
</html>