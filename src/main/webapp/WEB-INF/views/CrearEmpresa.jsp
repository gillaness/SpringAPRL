<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APRL - Sistema de Seguridad Ocupacional</title>
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
</head>
<body>
<div class="contenedor">
	<h3>Crear Empresa</h3>
	
	<c:if test="${mensaje != null}">
	<c:out value="${mensaje}" />
	</c:if>
		
		<form action="CrearEmpresa" method="post">
    <div class="form-group">
      <label for="rute">Rut Empresa</label>
      <input type="text" class="form-control" placeholder="Rut Empresa" name="rute">
    </div>
    <div class="form-group">
      <label for="empresa">Nombre Empresa</label>
      <input type="text" class="form-control" placeholder="Nombre Empresa" name="empresa">
      </div>
    <div class="form-group">
      <label for="direccion">Direcci�n Empresa</label>
      <input type="text" class="form-control" placeholder="Direcci�n Empresa" name="direccion">
    </div>
    <div class="form-group">
      <label for="contacto">Contacto Empresa</label>
      <input type="text" class="form-control" placeholder="Contacto Empresa" name="contacto">
    </div>
    <div class="form-group">
      <label for="telefono">Tel�fono Contacto</label>
      <input type="text" class="form-control" placeholder="Tel�fono Contacto" name="telefono">
    </div>
    <div class="form-group">
      <label for="correo">Email Contacto</label>
      <input type="email" class="form-control" placeholder="Email contacto" name="correo">
    </div>
    <div class="form-group">
      <label for="cantidad">Cantidad Empleados</label>
      <input type="text" class="form-control" placeholder="cantidad contacto" name="cantidad">
    </div>
		<br>
		<button type="submit" class="btn btn-primary" name="crearempresa" value="Crear Empresa">Crear Empresa</button>
		<br><br>
		<input type="hidden" name="${_csrf.parameterName} "value="${_csrf.token}"/> 
	</form>
		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/VistaAdministrador';" class="btn btn-primary" value="Volver">Volver</button>
    	
    	<button type="submit" onclick="window.location.href='logout';" class="btn btn-primary" value="Cerrar Sesi�n">Cerrar Sesi�n</button>
	</div>
</body>
</html>