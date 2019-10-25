<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenido <c:out value="${user.username}"/></title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
</head>
<body>
	<section class="section">
		<div class="container">
			<div class="columns">
				<div class="column is-one-third is-offset-one-third">
					<c:choose>
						<c:when test="${user != null}">
							<div class="box">
								<div class="content has-text-centered">
		                        	<h3>Bienvenido <c:out value="${user.username}"/></h3>
		                    	</div>
								<div class="content">
									<h4>Datos</h4>
									<p>
										<strong>Username:</strong> <c:out value="${user.username}"/><br>
										<strong>Nombre:</strong> <c:out value="${user.firstname}"/> <c:out value="${user.lastname}"/><br>
										<strong>Rut:</strong> <c:out value="${user.rut}"/>
									</p>
									<p><a class="button is-danger is-fullwidth" href="./Logout">Logout</a></p>
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<c:redirect url = "./"/>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</section>
</body>
</html>