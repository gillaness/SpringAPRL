<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APRL</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
	<div class="contenedor">
	<h3>Listado de Usuarios del Sistema</h3>
<c:set var="mensaje" value="${mensaje}"></c:set>	
<c:if test="${mensaje != null}">
	<c:out value="${mensaje}" />
</c:if>
		
		<table class="table">
		<thead class="thead-dark">
		<tr>
		<th scope="col">Nombre Usuario</th>
        <th scope="col">UserID</th>
        <th scope="col">Rut Empresa</th>
        <th scope="col">Empresa</th>
        <th scope="col">Perfil</th>
        <th scope="col">Acciones</th>
        </tr>
        </thead>
		
	<c:forEach items="${listausers}" var="user">
		<tr>
			<td>${user.getNombre()}</td>
			<td>${user.getId()}</td>
			<td>${user.getEmpresa()}</td>
			<td>${user.getNombreEmpresa()}</td>
			<td>${user.getPerfilNombre()}</td>
			
			
			<td><a href="${pageContext.request.contextPath}/EditarUsuario/${user.getId()}">Editar</a> &nbsp; 
			<a href="${pageContext.request.contextPath}/BorrarUsuario/${user.getId()}">Eliminar</a> &nbsp;
			<a href="${pageContext.request.contextPath}/CambiarPassword/${user.getId()}">Cambiar Password</a></td>
			
		</tr>	
	</c:forEach>
		
	</table>
	<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/';" class="btn btn-primary" value="Volver">Volver</button>
    
    <button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/Logout';" class="btn btn-primary" value="Cerrar Sesión">Cerrar Sesión</button>
		<%-- <a href="${pageContext.request.contextPath}/Logout">Cerrar sesión</a><br/> --%>
	</div>
</body>
</html>