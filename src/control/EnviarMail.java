package control;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarMail {
	
	private String asdqwe = "nicolas.maggione@gmail.com";
	private String lkjas = "1087890737390457869587509857565";
	
	public void enviarEmail(String emailRemi, String codigo) {
	    try{
	        // Propiedades de la conexión
	        Properties props = new Properties();
	        props.setProperty("mail.smtp.host",  "smtp.gmail.com");
	        props.setProperty("mail.smtp.user", asdqwe);
	        props.setProperty("mail.smtp.starttls.enable", "true");
	        props.setProperty("mail.smtp.port", "587");
	        props.setProperty("mail.smtp.auth", "true");
	 
	        // Preparamos la sesion
	        Session session = Session.getDefaultInstance(props);
	        
		    //Recoger los datos
		    String str_De = asdqwe;
		    lkjas = this.hshd(lkjas);
		    String str_PwRemitente = lkjas;                
		    String str_Para = emailRemi;
		    String str_Asunto = "Código de Validación - Kioskoandado";
		    String str_Mensaje = "Este es su código: "+codigo+". Instroduscalo en el campo indicando para validar su cuenta";
		    //Obtenemos los destinatarios
		    String destinos[] = str_Para.split(",");
	                 
	        // Construimos el mensaje
	        MimeMessage message = new MimeMessage(session);
	         
	        message.setFrom(new InternetAddress( str_De ));
	 
		    //Otra forma de especificar las direcciones de email 
		    //a quienes se enviar el correo electronico
		    //Forma 1
		        //Address [] receptores = new Address []{
		    //      new InternetAddress ("fuerenio@gmail.com"),
		    //      new InternetAddress ("gonzasilve@gmail.com")
		    //  };
		    //Forma 2
		    //  Address [] receptores = new Address []{
		    //      new InternetAddress ( str_De )
		    // };
		    //Forma 3
	        Address [] receptores = new Address [ destinos.length ];
	        int j = 0;
	        while(j<destinos.length){                    
	        	receptores[j] = new InternetAddress ( destinos[j] ) ;                   
	        	j++;                
	        }
	         
	        //receptores.
	        message.addRecipients(Message.RecipientType.TO, receptores);        
	        message.setSubject( str_Asunto );        
	        message.setText( str_Mensaje );
	             
	        // Lo enviamos.
	        Transport t = session.getTransport("smtp");
	        t.connect(str_De, str_PwRemitente);
	        t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
	                 
	        // Cierre de la conexion.
	        t.close();
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }       
	}
	
	private String hshd(String hdhs){
		int i = hdhs.indexOf("4");
		return(hdhs.substring(0, i));
	}
	     
}
