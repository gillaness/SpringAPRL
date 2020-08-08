<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APRL - Sistema de Seguridad Ocupacional</title>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<div class="contenedor">
		<h3>Crear Usuario</h3>

		<c:if test="${mensaje != null}">
			<c:out value="${mensaje}" />
		</c:if>

		<form action="CrearUsuario" method="post">
			<div class="form-group">
				<label for="rut">Rut</label> <input type="text" class="form-control"
					placeholder="RUT" name="rut">
			</div>
			<div class="form-group">
				<label for="nombre">Nombre</label> <input type="text"
					class="form-control" placeholder="Nombre" name="nombre">
			</div>
			<div class="form-group">
				<label for="pass">Password</label> <input type="password"
					class="form-control" placeholder="Password" name="pass">
			</div>
			<div class="form-group">
				<label for="perfil">Rol</label> <select name="perfil"
					class="form-control" placeholder="Rol">
					<option value="1">Administrador</option>
					<option value="3">Cliente</option>
					<option value="2">Profesional</option>
				</select>
			</div>
			<div class="form-group">
				<label for="empresa">Empresa</label> <select name="empresa"
					class="form-control" placeholder="Empresa">
					<c:forEach items="${listaempresas}" var="empresa">
						<option value="${empresa.getRutEmpresa()}">${empresa.getNombreEmpresa()}</option>
					</c:forEach>
					<!-- <option value="1">APRL</option> -->
				</select>
			</div>

			<br>
			<button type="submit" class="btn btn-primary" value="Crear Usuario">Crear
				Usuario</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> <br> <br>
		</form>
		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/VistaAdministrador';" class="btn btn-primary" value="Volver">Volver</button>
		<button type="submit"
			onclick="window.location.href='${pageContext.request.contextPath}/Logout';"
			class="btn btn-primary" value="Cerrar Sesión">Cerrar Sesión</button>
	</div>
</body>
</html>