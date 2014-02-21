package registros;

import conexionDB.ConexionDB;
import control.Tools;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistroNuevoUsuario
 */
public class RegistroNuevoUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroNuevoUsuario() {
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
		registrarUsuario(request,response);
	}
	
	private void registrarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ConexionDB db = (ConexionDB) getServletContext().getAttribute("baseDeDatos");
		String nombre = request.getParameter("regNomUs");
		String apellido = request.getParameter("regApUs");
		String email = request.getParameter("regEmaUs");
		String contrasena = request.getParameter("regContUs");
		String direccion = request.getParameter("regDirUs");
		int telefono = request.getParameter("regTelUs");
		
		//Obtenemos la ruta absoluta del sistema donde queremos guardar la imagen
        String fileName = this.getServletContext().getRealPath("/img/fotoPerfil");
        String fotoPerfil = request.getPart("regFotoPerfilUs");
        //Guardamos la imagen en disco con la ruta que hemos obtenido en el paso anterior
        boolean ok = Tools.guardarImagenDeProdructoEnElSistemaDeFicheros(request.getPart("regFotoPerfilUs").getInputStream(), fileName);
        if (ok == false){
            request.setAttribute("mensaje", "Fallo al guardar archivo. Intente nuevamente");
            Tools.anadirMensaje(request, "Ocurrio un error guardando la imagen");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            return;
        }else{
        	request.setAttribute("mensaje", "nombre... apellido.... "
        			+ "email.... contrasena.... direccion... telefono..."
        			+ "fotoPerfil...."
        			+ "Verifique su Correo. Un código de verificacion fue enviado para ingresarlo aquí");
            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
            return;
        }
	}

}
