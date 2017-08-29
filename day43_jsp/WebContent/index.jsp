<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>西瓜</div>
	<div>123456</div>
	<div>现在的时间是：</div>
	<%-- <%@ include file="/data.jsp" %> --%>
	<jsp:include page="/data.jsp"/>
</body>
</html>