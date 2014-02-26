<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KioskoMandado - Registro</title>
	<link rel="icon" type="image/png" href="img/icono.png" />
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<link rel="stylesheet" type="text/css" href="css/registro.css">
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<header>
		<%@ include file="jsp/header.jsp" %>
	</header>
	<section>
		<div id="selecTipoReg">
			<h2>Seleccione el tipo de registro:</h2>
			<div>
				<button id="formularioRegKiosko">Como Kiosko</button>
				<button id="formularioRegUsuario">Como Usuario</button>
			</div>
		</div>
		<div id="regUsuario">
			<form action="registroUsuario" method="POST" enctype="multipart/form-data">
				<fieldset>
					<legend>Registro de Nuevo Usuario</legend>
					<div id="regNomUs">
						<label>Nombre:</label>
						<input type="text" name="regNomUs">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regApUs">
						<label>Apellido:</label>
						<input type="text" name="regApUs">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regEmaUs">
						<label>E-mail:</label>
						<input type="email" name="regEmaUs">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regContUs">
						<label>Contraseña:</label>
						<input type="password" name="regContUs">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regDirUs">
						<label>Dirección:</label>
						<input type="text" name="regDirUs">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regTelUs">
						<label>Teléfono:</label>
						<input type="text" name="regTelUs">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regFotoPerfilUs">
						<label>Foto Perfil:</label>
						<input type="file" name="regFotoPerfilUs">
						<div>
							<span></span>
						</div>
					</div>
					<p>
						Aclaración:  
					</p>
					<ul>
						<li>
							En la foto de perfil debe aparecer el rostro del usuario únicamente. No debe ingresarse fotos grupales.
						</li>
						<li>
							Las fotos ingresadas deben ser de formato jpg o png.
						</li>
						<li>
							Los datos ingresados deben ser reales y serán corroborados por el administrador.
						</li>	
						<li>
							Los datos ingresados son utilizados para poder enviar tus pedidos al lugar correctos. Son de total privacidad los mismo y a los cuales solo el administrador tiene acceso.
						</li>
						<li>
							Por más información no dude en consultarnos.
						</li>
					</ul>
					<p>
						Cualquier incumplimiento en estas pautas, usted no será dado de alta por el administrador.
					</p>
					<input id="subRegUs" type="submit" value="Registrar">
				</fieldset>
			</form>
			<br><br>
		</div>
		<div id="regKiosko">

		</div>
	</section>
	<footer>
		<%@ include file="html/footer.html" %>
	</footer>
</body>
</html>