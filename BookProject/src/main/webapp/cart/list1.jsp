<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="css/booklist.css">
<link rel="stylesheet" type="text/css" href="css/book.css">
</head>
<body>

	<div id="wrap" align="center">
		<h1>장바구니 리스트</h1>
		<form action="BookServlet" method="post" name="frm">
			<input type="hidden" name="command" value="cart_delete"> <input
				type="hidden" name="cartnum" value="${cart.cartnum}">
			<table class="list">
				<c:if test="${not empty requestScope.cartList }">
					<c:forEach var="item" items="${requestScope.cartList }"
						varStatus="status">
						<tr class="calculation_tbody_tr1" style="height: 90px;">
							<td
								style="text-align: left; text-align: center; border-right: none;">
								<input type="checkbox" id="check${status.index }"
								name="checkbox" /> <input type="hidden"
								class="buybook${status.index }" value="${cart.num }"> <input
								type="hidden" name="cartAllCnt" value="" id="cartAllCnt" />

							</td>
							<td style="border-left: none; border-right: none;"><img
								style="width: 150px;" src="${book.pictureurl}">
							<td
								style="text-align: left; padding-left: 10px; border-left: none; font-weight: bold;">${book.title }(${book.title })</td>
							<td><span style="padding-left: 10px;"
								class="order_price${status.index }" style="text-align: right;"></span>
							<td><input class="spiner spiner${status.index }"
								name="spiner${status.index }" style="text-align: right;">
							</td>

							<td>-</td>
							<td>기본배송</td>
							<td>2,500원</br>고정
							</td>


							<td><span class="sum sum${status.index }"></span>원</td>
							<td>
								<button type="button" class="btn">주문하기</button>
								<button type="button" class="btn">x 삭제</button> <input
								type="hidden" class="cartnum${status.index }"
								name="cartnum${status.index }" value="${book.num }">
							</td>
						</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>