<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="login">
	Ingresar
</div>
<div id="registrarse">
	Registrarse
</div>
<div id="ingreso">
	<form action="" method="get">
		<label id="labelIngreUsu">Usuario:</label>
		<input id="inputTextIngre" class="inputTextIngre" type="text" placeholder="ejemplo@ejemplo.com" name="usuario">
		<label id="labelIngreCon">Contraseña:</label>
		<div id="contrasenaIngre">
			<input class="inputTextIngre" type="password" name="contrasena">
			<div>
				<a href="#">Olvidaste tu contraseña??</a>
			</div>
		</div>
		<input id="buttonIngre" type="submit" value="Entrar">
	</form>
</div>

<hgroup>
	<h1>Kiosko Mandado</h1>
	<h2>facilitando tu vida...</h2>
</hgroup>
<%
	String mensaje = (String)request.getAttribute("registro");
	if(mensaje=="registrado"){
%>
	<%@ include file = "../html/menuUsComun.html" %>
<%
	}else{
%>
	<%@ include file = "../html/menuComun.html" %>
<%
	}
%>