$(document).on("ready", inicio);

function inicio () {
	$("#login").on("click",aparecerLogin);
}

function aparecerLogin(){
	if ( $( "#ingreso" ).is(":hidden") ) {
    	$("#ingreso").show(250);
  	} else {
    	$("#ingreso").css("display","none");
  	}
}