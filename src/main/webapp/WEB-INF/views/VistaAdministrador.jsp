<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	 <h3>Mantención Usuarios del Sistema</h3>   
                
        <div class="mus" role="group" aria-label="Button group with nested dropdown">
		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/CrearUsuario';" class="btn btn-secondary" value="Crear Nuevo Usuario">Crear Nuevo Usuario</button>
  		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/VerUsuarios';" class="btn btn-secondary" value="Ver Listado de Usuarios">Ver Listado de Usuarios</button>
		<br><br>
                
    	<h3>Mantención de Clientes Empresas</h3> 
                
        <div class="mce" role="group" aria-label="Button group with nested dropdown">
		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/CrearEmpresa';" class="btn btn-secondary">Crear Nuevo Cliente Empresa</button>
  		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/VerEmpresas';" class="btn btn-secondary">Ver Listado de Clientes Empresa</button>
  		<button type="submit" onclick="window.location.href='${pageContext.request.contextPath}/Accidentabilidad';" class="btn btn-secondary">Ver Accidentabilidad por Empresa</button>
		<br><br>
         
        <button type="submit" onclick="window.location.href='logout';" class="btn btn-primary" value="Cerrar Sesión">Cerrar Sesión</button>
	</div>
</body>
</html>

