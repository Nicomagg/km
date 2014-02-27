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
							SI ALGUNA INFORMACIÓN ES FALSA O SE ROMPE ALGUNA REGLA DE KIOSKO MANDADO(la cual puede ver aquí: <a href="/reglas.jsp">Reglas de Kiosko Mandado</a>, USTED SERÁ DADO DE BAJA POR EL ADMINISTRADOR.
						</li>
						<li>
							Por más información no dude en consultarnos.
						</li>
					</ul>
					<p>
						Cualquier incumplimiento en estas pautas, usted no será dado de alta por el administrador.
					</p>
					<input id="subRegUs" type="submit" value="Registrar Usuario">
				</fieldset>
			</form>
			<br><br>
		</div>
		<div id="regKiosko">
			<form action="RegistroKiosko" method="POST" enctype="multipart/form-data">
				<fieldset>
					<legend>Registro de Nuevo Kiosko</legend>
					<div id="regCuitKio">
						<label>Cuit:</label>
						<input type="text" name="regCuitKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regNomDueKio">
						<label>Nombre Dueño:</label>
						<input type="text" name="regNomDueKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regApDueKio">
						<label>Apellido Dueño:</label>
						<input type="text" name="regApDueKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regNomKio">
						<label>Nombre Kiosko:</label>
						<input type="text" name="regNomKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regEmaKio">
						<label>E-mail:</label>
						<input type="email" name="regEmaKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regContKio">
						<label>Contraseña:</label>
						<input type="password" name="regContKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regDirKio">
						<label>Dirección:</label>
						<input type="text" name="regDirKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regTelKio">
						<label>Teléfono:</label>
						<input type="text" name="regTelKio">
						<div>
							<span></span>
						</div>
					</div>
					<div id="regFotoPerfilKio">
						<label>Foto Perfil Kiosko:</label>
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
							En la foto de perfil debe aparecer una foto del exterior del kiosko para que los usuario puedan reconocer el mismo.
						</li>
						<li>
							Las fotos ingresadas deben ser de formato jpg o png.
						</li>
						<li>
							Los datos ingresados deben ser reales y serán corroborados por el administrador.
						</li>	
						<li>
							Los datos ingresados son utilizados para que los usuario conoscan más sobre el comercio y para que nosotros podamos mantener un control de nuestros kioskos asociados y ante cualquier problema poder contactarnos con ustedes.
						</li>
						<li>
							SI ALGUNA INFORMACIÓN ES FALSA O SE ROMPE ALGUNA REGLA DE KIOSKO MANDADO(la cual puede ver aquí: <a href="/reglas.jsp">Reglas de Kiosko Mandado</a>, USTED SERÁ DADO DE BAJA POR EL ADMINISTRADOR.
						</li>
						<li>
							Por más información no dude en consultarnos.
						</li>
					</ul>
					<p>
						Cualquier incumplimiento en estas pautas, usted no será dado de alta por el administrador.
					</p>
					<input id="subRegkio" type="submit" value="Registrar Kiosko">
				</fieldset>
			</form>
			<br><br>
		</div>
	</section>
	<footer>
		<%@ include file="html/footer.html" %>
	</footer>
</body>
</html>