$(document).on("ready", inicio);

function inicio () {
	analisisPosicionMenu();
	$("#login").on("click",aparecerLogin);
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
	switch(url){
		case "/km/":
			$("nav ul li").removeClass();
			$("#navInicio").addClass('active');
			break;
	}
}