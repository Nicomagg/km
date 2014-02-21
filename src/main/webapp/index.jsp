<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>KioskoMandado - Inicio</title>
	<link rel="icon" type="image/png" href="img/icono.png" />
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="css/header.css">
	<link rel="stylesheet" type="text/css" href="css/footer.css">
	<script src="js/modernizr-2.6.2.min.js"></script>
	<script src="js/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="js/main.js"></script>
</head>
<body>
	<header>
		<%@ include file = "jsp/header.jsp" %>
	</header>
	<section>
		<h2>Acerca de...</h2>
			<p>
				Cuantas veces necesitamos algo de un kisko (gaseosa, hielo, masitas, etc.), pero por distintos motivos(altas/bajas temperaturas, falta de tiempo, etc.) no pudimos ir.
			</p>
			<p>
				KiskoMandado se crea con el objetico de brindar una mayor comodidad a las personas dandoles las posibilidad de hacer sus compras por este medio y evitar así tener que moverser de sus hogares.
			</p>
		<br>

		<h2>Cómo realizo un pedido??...</h2>
			<p>
				Para realizar un pedido simplemente debe serguir estos pasos:
			</p>
			<ul>
				<li>Primero debe registrarse como usuario</li>
				<li>Luego, debe seleccionar el kiosko al cual desea realizar su pedido</li>
				<li>Debe esperar que el kiosko confirma su solicitud (ya que por falta de stock puede que su pedido no sea atendido). Si esto ocurre, el pedido se da de baja y usted puede realizar su pedido en otro kiosko</li>
				<li>Por último, solo debe esperar su pedido en su domicilio</li>
			</ul>
			<p>
				Si usted posee más dudas como.. ¿Cómo puedo registrar mi kiosko?, ¿Donde puedo quejarme por pedido incumplidos? ¿Como comunicarme con el administrador?.. y muchas más consultas, te invitamos a que ingreses en la pestaña "Ayuda" en el menu más arriba 
			</p>
		<br><br><br>
	</section>
	<footer>
		<%@ include file = "html/footer.html" %>
	</footer>
</body>
</html>
