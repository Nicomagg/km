package registros;

import conexionDB.ConexionDB;

import java.io.*; 
import java.net.*; 

import javax.servlet.*; 
import javax.servlet.http.*; 

/**
 * Servlet implementation class RegistroNuevoUsuario
 */
public class RegistroNuevoUsuario extends HttpServlet{
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
		String telefono = request.getParameter("regTelUs");
		String fotoPerfil = request.getParameter("regFotoPerfilUs");
		
		File origen = new File(fotoPerfil);
        File destino = new File("/img/fotoPerfil/"+email+".png");

        try {
        	InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);
            
            byte[] buf = new byte[1024];
            int len;
 
            while ((len = in.read(buf)) > 0)
            {
              out.write(buf, 0, len);
            }
 
            in.close();
            out.close();
        } catch (IOException ioe){
            ioe.printStackTrace();
            System.out.println("Errooooooorrrrrrrrr11111");
        }
		
        request.setAttribute("error","Verifique su Correo. Un código de verificacion fue enviado para ingresarlo aquí");
        request.getRequestDispatcher("mensaje.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		//Obtenemos la ruta absoluta del sistema donde queremos guardar la imagen
//        String fileName = this.getServletContext().getRealPath("/img/fotoPerfil");
//		String fotoPerfil = request.getParameter("regFotoPerfilUs");
//        //Guardamos la imagen en disco con la ruta que hemos obtenido en el paso anterior
//        boolean ok = Tools.guardarImagenDeProdructoEnElSistemaDeFicheros(request.getPart("regFotoPerfilUs").getInputStream(), fileName);
//		if (ok == false){
////            request.setAttribute("error", "Fallo al guardar archivo. Intente nuevamente");
////            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
////            return;
//        }else{
//        	request.setAttribute("error",
//        			nombre+"\n"+
//        			apellido+"\n"+
//        			email+"\n"+
//        			contrasena+"\n"+
//        			direccion+"\n"+
//        			telefono+"\n"+
//        			fotoPerfil+"\n"
//        			+ "Verifique su Correo. Un código de verificacion fue enviado para ingresarlo aquí");
//            request.getRequestDispatcher("mensaje.jsp").forward(request, response);
//        }
	}

}