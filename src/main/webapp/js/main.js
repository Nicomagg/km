$(document).on("ready", inicio);

function inicio () {
	$("#login").on("click",aparecerLogin);
}

function aparecerLogin(){
	if ( $( "#ingreso" ).is("hidden") ) {
    	$("#ingreso").slideUp("slow");
  	} else {
    	$("#ingreso").slideDown("slow");
  	}
}