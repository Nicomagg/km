<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KioskoMandado - Registro(Validación)</title>
	<link rel="icon" type="image/png" href="img/icono.png" />
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" type="text/css" href="css/validacion.css">
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
	
</head>
<body>
	<header>
		<%@ include file="jsp/header.jsp" %>
	</header>
	<section>
		<h2>Validar Cuenta (Verifique su correo para obtener el código de aprobación)</h2>
		<form id="formValidacion" action="ValidacionRegistro" method="GET">
			<div id="emaValid">
				<label>Email:</label>
				<input type="email" name="emaValid">
			</div>
			<span id="emaValidSpan"></span>
			<div id="codigAprob">
				<label>Código Aprobación:</label>
				<input type="text" name="codigAprob">
			</div>
			<span id="codigAprobSpan"></span>
			<br>
			<input class="radiosButtonsValid" type="radio" name="tipoRegVal" value="kioskoVal" checked><label>Kiosko</label>
			<input class="radiosButtonsValid" type="radio" name="tipoRegVal" value="usuarioVal"><label>Usuario</label>
			<br>
			<input id="buttonValidar" type="submit" value="Validar">
		</form>
	</section>
	<footer>
		<%@ include file="html/footer.html" %>
	</footer>
</body>
</html>