<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
<script src="js/functions.js"></script>
</head>
<body>
    <section class="section">
        <div class="container">
            <div class="columns">
                <div class="column is-one-third is-offset-one-third">
                    <c:choose>
                        <c:when test="${user == null}">
                            <div class="box">
                                <div class="content has-text-centered">
                                    <h3>Login</h3>
                                </div>
                                <form action="AdminUser" method="POST" id="form" onsubmit="return validate()">
                                    <div class="field">
                                        <div class="control">
                                            <input class="input" type="text" placeholder="Username" name="username" onfocusout="checkUsername()">
                                            <small id="error" class="has-text-danger is-hidden">El campo no puede estar vacío</small>
                                        </div>
                                    </div>
                                    <div class="field">
                                        <div class="control">
                                            <input class="input" type="password" placeholder="Password" name="pass" onfocusout="checkPass()">
                                            <small id="errorPass" class="has-text-danger is-hidden">Debe ingresar una contraseña</small>
                                        </div>
                                    </div>
                                    <div class="field">
                                        <div class="control">
                                            <c:if test="${error}">
                                                <p class="has-text-danger">Usuario o contraseña inválida</p>
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="field">
                                        <div class="control">
                                            <input class="button is-primary is-fullwidth" type="submit" value="Login">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </c:when>
						<c:otherwise>
							<c:redirect url = "./welcome.jsp"/>
						</c:otherwise> 
					</c:choose>
                </div>
            </div>
        </div>
    </section>
</body>
</html>