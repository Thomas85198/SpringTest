<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Image Page</title>
</head>
<body>
My Image:<br/>
<img src="<c:url value="/images/image01.jpg"></c:url>"/><br/>
</body>
</html>