<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 확인</title>
<script type="text/javascript" src="script/member.js"></script>
<link rel="stylesheet" href="css/book.css">
</head>
<body>
	<div align="center">
		<form action="BookServlet" name="frm" method="get">
			<input type="hidden" name="command" value="cart_check_form"> <input
				type="hidden" name="id" value="${member.id}">
			<table style="width: 80%">
				<tr>
					<th colspan="2">장바구니에 담았습니다.</th>
				</tr>
				<tr>
					<td><input type="submit" value="장바구니로 가기 "
						onclick="location.href='BookServlet?command=cart_list'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" value="쇼핑 계속하기"
						onclick="go.history(-1)"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>