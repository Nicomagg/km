package registros;

import java.io.IOException;
import java.io.File;
import java.io.Serializable;
import java.util.*;

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
			System.out.println("Primer catch");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Segundo catch");
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
		String fotoPerfil = getServletContext().getRealPath("/img/fotoKiosko"+nombreFoto);
		System.out.println(cuit+" "+nombreDuenio+" "+apellidoDuenio+" "+nombreKiosko+" "+email+" "+contrasena+" "+direccion+" "+tel+" "+fotoPerfil);
		
		//Generamos el codigo de aprobacion
		String codigoAprobacion = this.generarCodigoAprobacion(email, apellidoDuenio);
		
		this.guardarEnBaseDeDatosUsuario(db, cuit, nombreDuenio, apellidoDuenio, nombreKiosko, email, contrasena, direccion, tel, fotoPerfil, false, codigoAprobacion);
		
		request.setAttribute("validar",true);
        request.setAttribute("error","Verifique su Correo. Un código de validación fue enviado para ingresarlo aquí(Funcionalidad no terminado. Todos los kioskos se dan de alta nomas)");
        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
		
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

}
