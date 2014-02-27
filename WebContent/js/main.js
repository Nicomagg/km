$(document).on("ready", inicio);

function inicio () {
	analisisPosicionMenu();
	$("#formularioRegUsuario").on("click",mostrarFormRegUsu);
	$("#formularioRegKiosko").on("click",mostrarFormRegKio);
	$("#login").on("click",aparecerLogin);
	$("#registrarse").on("click",redirecRegistro);
	$("#regKiosko form").on("submit",controlRegKio);
	$("#regUsuario form").on("submit",controlRegUs);
}

function aparecerLogin(){
	if ( $( "#ingreso" ).is(":hidden") ) {
    	$("#ingreso").show(30);
  	} else {
    	$("#ingreso").css("display","none");
  	}
}

//verifica si debe marcar un menu o no
function analisisPosicionMenu() {
	var url = $(location).attr('pathname');
	$("nav ul li").removeClass();
	switch(url){
		case "/km/":
			$("#navInicio").addClass('active');
			break;
	}
}

//Valida formulario de registro de kiosko antes de enviarse
function controlRegKio(event) {
	//Lipio los campos que pudieron haber sido marcados en una primera Instancia
	$("#regKiosko span").text("");
	$("#regKiosko form fieldset div").removeClass("errorCampoRegUs");

	//Busco campos inválidos
	if(isNaN($("#regCuitKio input").val())||(!($("#regCuitKio input").val()!=""))){
		if (isNaN($("#regCuitKio input").val())) {
			$("#regCuitKio div span").text("El valor ingresado debe ser un número");
		};
		if(!($("#regCuitKio input").val()!="")){
			$("#regCuitKio div span").text("Campo incompleto");
		};
		$("#regCuitKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if(!(isNaN($("#regNomDueKio input").val()))||(!($("#regNomDueKio input").val()!=""))||(($("#regNomDueKio input").val().length) > 50)){
		if (!(isNaN($("#regNomDueKio input").val()))) {
			$("#regNomDueKio div span").text("El valor ingresado no debe ser un número");
		};
		if(!($("#regNomDueKio input").val()!="")){
			$("#regNomDueKio div span").text("Campo incompleto");
		};
		if (($("#regNomDueKio input").val().length) > 50) {
			$("#regNomDueKio div span").text("El texto ingresado debe ser menor a 50 caracteres");
		};
		$("#regNomDueKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if(!(isNaN($("#regApDueKio input").val()))||(!($("#regApDueKio input").val()!=""))||(($("#regApDueKio input").val().length) > 50)){
		if (!(isNaN($("#regApDueKio input").val()))) {
			$("#regApDueKio div span").text("El valor ingresado no debe ser un número");
		};
		if(!($("#regApDueKio input").val()!="")){
			$("#regApDueKio div span").text("Campo incompleto");
		};
		if (($("#regApDueKio input").val().length) > 50) {
			$("#regApDueKio div span").text("El texto ingresado debe ser menor a 50 caracteres");
		};
		$("#regApDueKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if(!(isNaN($("#regNomKio input").val()))||(!($("#regNomKio input").val()!=""))||(($("#regNomKio input").val().length) > 50)){
		if (!(isNaN($("#regNomKio input").val()))) {
			$("#regNomKio div span").text("El valor ingresado no debe ser un número");
		};
		if(!($("#regNomKio input").val()!="")){
			$("#regNomKio div span").text("Campo incompleto");
		};
		if (($("#regNomKio input").val().length) > 50) {
			$("#regNomKio div span").text("El texto ingresado debe ser menor a 50 caracteres");
		};
		$("#regNomKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if (($("#regEmaKio input").val().indexOf('@', 0) == -1) || ($("#regEmaKio input").val().indexOf('.', 0) == -1)) {
		$("#regEmaKio div span").text("Correo no válida");	
		$("#regEmaKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if (($("#regContKio input").val()=="")||($("#regContKio input").val().length > 99)) {
		if ($("#regContKio input").val()=="") {
			$("#regContKio div span").text("Campo incompleto");
		};
		if ($("#regContKio input").val().length > 100) {
			$("#regContKio div span").text("El texto ingresado debe ser menor a 100 caracteres");	
		};
		$("#regContKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if(!(isNaN($("#regDirKio input").val()))||(!($("#regDirKio input").val()!=""))||(($("#regDirKio input").val().length) > 50)){
		if (!(isNaN($("#regDirKio input").val()))) {
			$("#regDirKio div span").text("El valor ingresado no debe ser solo numérico");
		};
		if(!($("#regDirKio input").val()!="")){
			$("#regDirKio div span").text("Campo incompleto");
		};
		if (($("#regDirKio input").val().length) > 100) {
			$("#regDirKio div span").text("El texto ingresado debe ser menor a 100 caracteres");
		};
		$("#regDirKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	if((isNaN($("#regTelKio input").val()))){
		$("#regTelKio div span").text("El valor ingresado debe ser solo numérico");
		$("#regTelKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};

	var file = $("#regFotoPerfilKio input").val();
	var ext = file.split('.').pop().toLowerCase();
	if ((file=="")||(($.inArray(ext, ['jpg']) == -1)&&($.inArray(ext, ['png']) == -1))) {
		if($("#regFotoPerfilKio input").val()==""){
			$("#regFotoPerfilKio div span").text("Campo incompleto");
		}
		if(($.inArray(ext, ['jpg']) == -1)&&($.inArray(ext, ['png']) == -1)){
		 	$("#regFotoPerfilKio div span").text("El archivo ingresado no corresponde a una imagen con extensión jsp o png");	
		}
		$("#regFotoPerfilKio").addClass("errorCampoRegUs");
		event.preventDefault();
	};
	alert("entra");
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
		$("#regTelUs").addClass("errorCampoRegUs");
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
		$("#regFotoPerfilUs").addClass("errorCampoRegUs");
		event.preventDefault();
	};

}

function mostrarFormRegUsu() {
	$("#regKiosko").css('display','none');
	$("#regUsuario").show(300);
}

function mostrarFormRegKio() {
	$("#regUsuario").css('display','none');
	$("#regKiosko").show(300);	
}

function redirecRegistro() {
	var url = $(location).attr('pathname');
	if(!(url == "/km/registro.jsp")){
		var url = "/km/registro.jsp";
		$(location).attr('href',url); 	
	}	
}