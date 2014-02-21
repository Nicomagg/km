$(document).on("ready", inicio);

function inicio () {
	analisisPosicionMenu();
	$("#login").on("click",aparecerLogin);
	$("#registrarse").on("click",redirecRegistro);
	$("#regUsuario form").on("submit",controlRegUs)
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

function controlRegUs(event) {
	if(!(isNaN($("#regNomUs input").val()))||(!($("#regNomUs input").val()!=""))){
		if (!(isNaN($("#regNomUs input").val()))) {
			$("#regNomUs div span").text("El valor ingresado no debe ser un número");
		}
		if(!($("#regNomUs input").val()!="")){
			$("#regNomUs div span").text("Campo incompleto");
		}
		$("#regNomUs").addClass("errorCampoRegUs");
		event.preventDefault();
	}
}

function redirecRegistro() {
	var url = $(location).attr('pathname')
	if(!(url == "/km/registro.jsp")){
		var url = "/km/registro.jsp"
		$(location).attr('href',url); 	
	}	
}