<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APRL || Editar Usuarios</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
</head>
<body>
	<div class="contenedor">
	<h3>Editar Usuarios</h3>
	
	<c:if test="${mensaje != null}">
	<c:out value="${mensaje}" />
	</c:if>
	<input type="text" value="${datos.toString()}">
	<form action="${pageContext.request.contextPath}/EditarUsuario" method="post">
	<table>
		<tr>
		<td><input type="hidden" name="userId" value="${datos.getId()}"></td>
		</tr>
		<tr>
		<td>Nombre</td>
		<td><input type="text" name="nombre" value="${datos.getNombre()}"></td>
		</tr>
		<tr>
		<td>Empresa</td>
		<td>
		<select name="empresa">
		<c:forEach items="${listaempresas}" var="empresa">
			<option value="${empresa.getRutEmpresa()}">${empresa.getNombreEmpresa()}</option>
		</c:forEach>
		</select>
		</td>
		</tr>
		<tr>
		<td>Perfil</td>
		<td><select name="perfil">
				<option value="1">Administrador</option>
				<option value="2">Profesional</option>
				<option value="3">Cliente</option>
		</select></td>
		</tr>
	</table>
		<br>
		<input type="submit" value="Modificar">
		<input type="hidden"
    name="${_csrf.parameterName}"
    value="${_csrf.token}"/> 
	</form>
	
	<button onclick="window.location.href='${pageContext.request.contextPath}/VerUsuarios';">
		Volver
    	</button>
    	
    <br/>
		<a href="${pageContext.request.contextPath}/Logout">Cerrar sesi�n</a><br/>
	</div>
</body>
</html>