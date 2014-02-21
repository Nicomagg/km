$(document).on("ready", inicio);

function inicio () {
	analisisPosicionMenu();
	$("#login").on("click",aparecerLogin);
	$("#registrarse").on("click",redirecRegistro);
	$("#regUsuario form").on("submit",controlRegUs);
	$("#formularioRegUsuario").on("click",mostrarFormRegUsu);
	$("#formularioRegKiosko").on("click",mostrarFormRegKio);
}

function aparecerLogin(){
	if ( $( "#ingreso" ).is(":hidden") ) {
    	$("#ingreso").show(30);
  	} else {
    	$("#ingreso").css("display","none");
  	}
}

function analisisPosicionMenu() {
	var url = $(location).attr('pathname');
	$("nav ul li").removeClass();
	switch(url){
		case "/km/":
			$("#navInicio").addClass('active');
			break;
		case "/km/registro.jsp":
			break;
	}
}

//Valida formulario de registro de usuario antes de enviarse
function controlRegUs(event) {
	//Lipio los campos que pudieron haber sido marcados en una primera Instancia
	$("#regUsuario span").text("");
	$("#regUsuario form fieldset div").removeClass("errorCampoRegUs");
	
	//Busco campos inválidos
	if(!(isNaN($("#regNomUs input").val()))||(!($("#regNomUs input").val()!=""))||(($("#regNomUs input").val().length) > 50)){
		if (!(isNaN($("#regNomUs input").val()))) {
			$("#regNomUs div span").text("El valor ingresado no debe ser un número");
		};
		if(!($("#regNomUs input").val()!="")){
			$("#regNomUs div span").text("Campo incompleto");
		};
		if (($("#regNomUs input").val().length) > 50) {
			$("#regNomUs div span").text("El texto ingresado debe ser menor a 50 caracteres");
		};
		$("#regNomUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if(!(isNaN($("#regApUs input").val()))||(!($("#regApUs input").val()!=""))||(($("#regApUs input").val().length) > 50)){
		if (!(isNaN($("#regApUs input").val()))) {
			$("#regApUs div span").text("El valor ingresado no debe ser un número");
		};
		if(!($("#regApUs input").val()!="")){
			$("#regApUs div span").text("Campo incompleto");
		};
		if (($("#regApUs input").val().length) > 50) {
			$("#regApUs div span").text("El texto ingresado debe ser menor a 50 caracteres");
		};
		$("#regApUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if (($("#regEmaUs input").val().indexOf('@', 0) == -1) || ($("#regEmaUs input").val().indexOf('.', 0) == -1)) {
		$("#regEmaUs div span").text("Correo no válida");	
		$("#regEmaUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if (($("#regContUs input").val()=="")||($("#regContUs input").val().length > 99)) {
		if ($("#regContUs input").val()=="") {
			$("#regContUs div span").text("Campo incompleto");
		};
		if ($("#regContUs input").val().length > 100) {
			$("#regContUs div span").text("El texto ingresado debe ser menor a 100 caracteres");	
		};
		$("#regContUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if(!(isNaN($("#regDirUs input").val()))||(!($("#regDirUs input").val()!=""))||(($("#regDirUs input").val().length) > 50)){
		if (!(isNaN($("#regDirUs input").val()))) {
			$("#regDirUs div span").text("El valor ingresado no debe ser solo numérico");
		};
		if(!($("#regDirUs input").val()!="")){
			$("#regDirUs div span").text("Campo incompleto");
		};
		if (($("#regDirUs input").val().length) > 100) {
			$("#regDirUs div span").text("El texto ingresado debe ser menor a 100 caracteres");
		};
		$("#regDirUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if((isNaN($("#regTelUs input").val()))){
		$("#regTelUs div span").text("El valor ingresado debe ser solo numérico");
		$("#regDirUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	var file = $("#regFotoPerfilUs input").val();
	var ext = file.split('.').pop().toLowerCase();
	if ((file=="")||(($.inArray(ext, ['jpg']) == -1)&&($.inArray(ext, ['png']) == -1))) {
		if($("#regFotoPerfilUs input").val()==""){
			$("#regFotoPerfilUs div span").text("Campo incompleto");
		}
		if(($.inArray(ext, ['jpg']) == -1)&&($.inArray(ext, ['png']) == -1)){
		 	$("#regFotoPerfilUs div span").text("El archivo ingresado no corresponde a una imagen con extensión jsp o png");	
		}
		$("#regFotoPerfilUs").addClass("errorCampoRegUs&&");
		event.preventDefault();
	};
}

function mostrarFormRegUsu() {
	//falta ocultar el formulario del kiosko
	$("#regUsuario").show(300);
}

function mostrarFormRegKio() {
	$("#regUsuario").css('display','none');
	//Falta mostrar el formulario para registrar el kiosko	
}

function redirecRegistro() {
	var url = $(location).attr('pathname')
	if(!(url == "/km/registro.jsp")){
		var url = "/km/registro.jsp"
		$(location).attr('href',url); 	
	}	
}