<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APRL || Cambiar Password</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
	<div class="contenedor">
	<h3>Modificar Password</h3>
	
	<c:if test="${mensaje != null}">
	<c:out value="${mensaje}" />
	</c:if>
	
	<form action="PasswordActualizado" method="post">
	<table>
		<tr>
		<td><input type="hidden" name="userId" value="${datos.getId()}"></td>
		</tr>
		<tr>
		<td><input type="hidden" name="nombre" value="${datos.getNombre()}"></td>
		</tr>
		<tr>
		<td><input type="hidden" name="perfil" value="${datos.getPerfil()}"></td>
		</tr>
		<tr>
		<td><input type="hidden" name="empresa" value="${datos.getEmpresa()}"></td>
		</tr>
		<tr>
		<td>Nuevo Password</td>
		<td><input type="password" name="password"></td>
		</tr>
		<tr>
		<td>Confirmar Password</td>
		<td><input type="password" name="password1"></td>
		</tr>
		
	</table>
		<br>
		<input type="hidden" name="${_csrf.parameterName} "value="${_csrf.token}"/> 
		<input type="submit" value="Cambiar Password">
		
	</form>
	
	<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/VerUsuarios';" class="btn btn-primary" value="Volver">Volver</button>
    	
    <br/>
		<a href="${pageContext.request.contextPath}/Logout">Cerrar sesión</a><br/>
	</div>
</body>
</html>