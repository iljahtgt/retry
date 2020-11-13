<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View hibernate</title>
</head>
<body bgcolor="antiquewhite">

	<table border="1" width="70%" bgcolor="pink">
		<tr>
			<th width="20%" id="id">Supplier ID</th>
			<th width="30%" id="name">Coffee Name</th>
			<th width="10%" id="price">price</th>
			<th width="20%" id="sales">sales</th>
			<th width="20%" id="total">total</th>
		</tr>
		<c:forEach var="current" items="${coffees}">
			<tr>
				<td><c:out value="${current.supId}" /></td>
				<td><c:out value="${current.cofName}" /></td>
				<td><c:out value="${current.price}" /></td>
				<td><c:out value="${current.sales}" /></td>
				<td><c:out value="${current.total}" /></td>
			</tr>
		</c:forEach>
	</table>
		
	<img src="image/a.jpg" width="30%" height="30%"><br>
	<img src="image/b.jpg" width="30%" height="30%">
	<img src="image/c.jpg" width="30%" height="30%">

</body>
</html>