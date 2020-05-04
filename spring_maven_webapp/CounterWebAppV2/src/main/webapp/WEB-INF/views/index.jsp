<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/img/favicon.ico.png" />
	<title>CounterWebAppV2</title>
</head>
<body>
	<h1>CounterWebAppV2</h1>
	
	<img src="${pageContext.request.contextPath}/assets/img/welcome.png" />
	<p>
	<strong>Message :</strong> ${message} <br/>
	<strong>Date : </strong> ${date} <br/>
	<strong>Counter :</strong> ${counter} <br/>
	</p>
</body>
</html>
