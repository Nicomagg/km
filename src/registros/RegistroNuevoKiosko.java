package registros;

import java.io.IOException;
import java.io.File;
import java.io.Serializable;
import java.util.*;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import conexionDB.ConexionDB;
/**
 * Servlet implementation class RegistroNuevoKiosko
 */
public class RegistroNuevoKiosko extends HttpServlet implements Serializable{
	private static final long serialVersionUID = 1L;
	private String dirUploadFiles;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroNuevoKiosko() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendError(404);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			registrarKiosko(request,response);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void registrarKiosko(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ConexionDB db = (ConexionDB) getServletContext().getAttribute("BaseDeDatos");
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// req es la HttpServletRequest que recibimos del formulario.
		// Los items obtenidos serán cada uno de los campos del formulario,
		// tanto campos normales como ficheros subidos.
		List items = upload.parseRequest(request);
		
		ArrayList<String> parametros = new ArrayList<String>();
		String nombreFoto = "";
		
		// Se recorren todos los items, que son de tipo FileItem
		for (Object item : items) {
			FileItem uploaded = (FileItem) item;
			
		   // Hay que comprobar si es un campo de formulario. Si no lo es, se guarda el fichero
		   // subido donde nos interese

			String rutaRelativaApp= getServletContext().getRealPath("/img/fotoKiosko");
			if (!uploaded.isFormField()) {
				
				int index =  (parametros.get(9)).indexOf(".com");
				nombreFoto = (String) (parametros.get(9)).subSequence(0, index);
				nombreFoto = nombreFoto + ".png";
				// No es campo de formulario, guardamos el fichero en algún sitio
				File fichero = new File(rutaRelativaApp, nombreFoto);
				uploaded.write(fichero);
			} else {
				// es un campo de formulario, podemos obtener clave y valor
				parametros.add(uploaded.getFieldName());
				parametros.add(uploaded.getString());
			}
		}
		
		String cuit = parametros.get(1);
		String nombreDuenio = parametros.get(3).toLowerCase();
		String apellidoDuenio = parametros.get(5).toLowerCase();
		String nombreKiosko = parametros.get(7).toLowerCase();
		String email = parametros.get(9).toLowerCase();
		String contrasena = parametros.get(11).toLowerCase();
		String direccion = parametros.get(13).toLowerCase();
		String tel = parametros.get(15);
		String fotoPerfil = getServletContext().getRealPath("/img/fotoKiosko/"+nombreFoto+".png");
		System.out.println(cuit+" "+nombreDuenio+" "+apellidoDuenio+" "+nombreKiosko+" "+email+" "+contrasena+" "+direccion+" "+tel+" "+fotoPerfil);
		
		//Generamos el codigo de aprobacion
		String codigoAprobacion = this.generarCodigoAprobacion(email, apellidoDuenio);
		
		this.guardarEnBaseDeDatosUsuario(db, cuit, nombreDuenio, apellidoDuenio, nombreKiosko, email, contrasena, direccion, tel, fotoPerfil, false, codigoAprobacion);
		this.enviarCodVal(email, codigoAprobacion);
        request.getRequestDispatcher("validacion.jsp").forward(request, response);
		
	}
	
	private String generarCodigoAprobacion(String email, String apellido){
		long num = (long)((Math.random()) * 5000000);
		int index =  email.indexOf("@");
		email = (String) email.subSequence(0, index);
		String codigo = email + num + apellido;
		return codigo;
	}
	
	private void guardarEnBaseDeDatosUsuario (ConexionDB db,String cuit, String nombreDuenio, String apellidoDuenio, String nombreKiosko , String email, String contrasena, String direccion, String tel, String fotoPerfil, boolean aprobacion, String codigoAprobacion){
		//Realizamos la pesistencia en la base de datos
		try{
			//Damos de alta una persona primero
			db.newUser(email, contrasena, nombreDuenio, apellidoDuenio);
			
			//Guardamos la imagen
			db.newImage(fotoPerfil);
	
			//BUscamos el id de la imagen creada
			int idFoto = db.searchIdImage(fotoPerfil);
			
			long numCuit = Long.parseLong(cuit);
			long telefono = Long.parseLong(tel);
			//Guardamos datos del usuario comun
			db.newCommerce(email, contrasena, nombreDuenio, apellidoDuenio, numCuit, nombreKiosko, direccion, telefono, idFoto, 0, aprobacion, codigoAprobacion);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void enviarCodVal(String email, String codigo){
		String adf = "nicolas.maggione@gmail.com";
		Properties props = new Properties();
		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");
		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port","587");
		// Nombre del usuario
		props.setProperty("mail.smtp.user", adf);
		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);//cuando ande sacar nomas esta linea
		
		MimeMessage message= new MimeMessage(session);
		try {
			// Quien envia el correo
			message.setFrom(new InternetAddress(adf));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			// A quien va dirigido
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			message.setSubject("Código validación - Kiosko Mandado");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			message.setText("Hola. Aquí esta tu código de validación... "+codigo);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Transport t = null;
		String asd = this.qwes();
		try {
			t = session.getTransport("smtp");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			t.connect(adf,asd);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.sendMessage(message,message.getAllRecipients());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String qwes(){
		double num = (((1*2)*5)+3);
		num = (double) Math.pow(num, 2);
		num = (num + 20.6312211);
		num = ((double) Math.pow(num, 2))-0.000015877085;
		num = ((((((num * 8 )+0.000001)+857.119926)*9)*2)-0.00001) - 5097330.000006001 + 2.0372681319713593E-10;
		long num1 = ((long)num)+1+1087794398;
		String asd = Long.toString(num1)+"390";
		return asd;
	}

}
