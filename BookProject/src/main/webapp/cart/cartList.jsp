<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 리스트</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/booklist.css">
<link rel="stylesheet" type="text/css" href="css/book.css">

</head>
<body>
	<div id="wrap" align="center">
		<h1>장바구니 리스트</h1>
		<form action="BookServlet" method="post" name="frm">
			<input type="hidden" name="command" value="cart_delete"> 
			<input type="hidden" name="cartnum" value="${cart.cartnum}">
			<table class="list">
				<tr>
					<th>선택</th>
					<td><input type="checkbox"  id="check" name="check">
					<th>no</th>
					<th>책 번호</th>
					<th>아이디</th>
					<th>가격</th>
					<th>제목</th>
					<th>포스터</th>
					<th>삭제</th>
				</tr>

				<c:forEach var="cart" items="${cartlist}">
					<tr class="record">
						<td>${cart.cartnum}</td>
						<td>${cart.num}</td>
						<td>${cart.id}</td>
						<td>${cart.price}</td>
						<td>${cart.title}</td>
						<td>${cart.pictureurl}</td>
						<td><input type="button" value="삭제" id="button"
							onclick="location.href='BookServlet?command=cart_delete&cartnum=${cart.cartnum}'"></td>

					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>