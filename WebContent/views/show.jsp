<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista  Artículos</h1>
	<table border="1" width="100%">
		<tr>
			<td>ID</td>
			<td>USERNAME</td>
			<td>PASSWORD</td>
			<td>FIRSTNAME</td>
			<td>LASTNAME</td>
			<td>RUT</td>
			<td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.id}"/></td>
				<td><c:out value="${user.username}"/></td>d
				<td><c:out value="${user.pass}"/></td>
				<td><c:out value="${user.firstname}"/></td>
				<td><c:out value="${user.lastname}"/></td>
				<td><c:out value="${user.rut}"/></td>
				<td>
					<a href="adminArticulo?action=showedit&id=<c:out value="${user.id}" />">Editar</a>
				</td>
				<td>
					<a href="adminArticulo?action=eliminar&id=<c:out value="${user.id}"/>">Eliminar</a>
				</td>				
			</tr>
		</c:forEach>
	</table>
</body>
</html>