<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test페이지</h1>


<form action="/purchase/buy" method="post">
id<br>
<input type="text" name="memberId"><br>
수신자
<input type="text" name="orderRec"><br>
addr
<input type="text" name="memberAddr1"><br>
<input type="text" name="memberAddr2"><br>
<input type="text" name="memberAddr3"><br>
phone
<input type="text" name="orderPhone"><br>
shipprice
<input type="text" name="shipPrice"><br>
total
<input type="text" name="totalPrice"><br>
amount
<input type="text" name="oDetail[0].amount"><br>
productId
<input type="text" name="oDetail[0].productId"><br>
amount
<input type="text" name="oDetail[1].amount"><br>
productId
<input type="text" name="oDetail[1].productId"><br>

cartID
<input type="text" name="cartId"><br>
<input type="text" name="cartId"><br>


point/money
<input type="text" name="usePoint">
<input type="text" name="totalPrice">
<input type="submit">
</form>
</body>
</html>