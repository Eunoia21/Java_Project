<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

if(window.name == 'go') {
	window.opener.parent.location.href =
		"BookServlet?command=cart_list&id=${cart.id}";
}else if(window.name == 'back'){
	window.close();
</body>
</html>