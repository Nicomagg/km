<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KioskoMandado - Contactos</title>
	<link rel="icon" type="image/png" href="img/icono.png" />
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" type="text/css" href="css/contacto.css">
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<header>
		<%@ include file = "jsp/header.jsp" %>
	</header>
	<section>
		<h2>Para contactarte con el administrador deja tu mensaje aquí...</h2>
		<form id="formComentario" action="" method="GET">
			<div>
				<label>Asunto:</label>
				<input type="text" name="asuntoMensaje">
			</div>
			<div>
				<h3>Mensaje:</h3>
				<textarea name="comentario" form="formComentario" maxlength="200">

				</textarea>
			</div>
			<input id="buttonEnviarComentario" type="submit" value="Enviar Comentario">
		</form>
		<div id="aclaracion">
			<h4>Aclaración:</h4>
			<ul>
				<li>Para realizar un comentario debe estar registrado</li>
				<li>Si desea comunicarse con un kiosko, busque el mismo en la sección kiosko y una vez encontrado el mismo, seleccione la pestaña comentarios y deje su comentario allí.</li>
			</ul>
		</div>
	</section>
	<footer>
		<%@ include file = "html/footer.html" %>
	</footer>
</body>
</html>