package registros;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionDB.ConexionDB;

/**
 * Servlet implementation class ValidacionRegistro
 */
public class ValidacionRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidacionRegistro() {
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
		this.validar(request, response);
	}
	
	private void validar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConexionDB db = (ConexionDB) getServletContext().getAttribute("BaseDeDatos");
		String email = request.getParameter("emaValid").toLowerCase();
		String codigoAprob = request.getParameter("codigAprob").toLowerCase();
		String tipoReg = request.getParameter("tipoRegVal");
		ResultSet r = null;
		boolean flag = false;
		String mensaje="";
		if(tipoReg.equals("kioskoVal")){
			try {
				r = db.searchCommerceForEmail(email);
				int i = 0;//Verifico si entra en el while nomas
				while(r.next()){
					i= i + 1;
					String codigo = r.getString("codigoaprobacion");
					if(!(codigo.equals(codigoAprob))){
						flag = true;//Señalo que el codigo no es igual
						mensaje = "Error de Validación. Código de Aprobación Incorrecto";
					}else{
						db.updateAprobCommerce(true, email);
					}
				}
				if(i==0){
					flag = true;//Señalo que hubo un error
					mensaje = "Error de Validación. Email inexistente o incorrecto";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(tipoReg.equals("usuarioVal")){
			try {
				r = db.searchCommonUserForEmail(email);	
				int i = 0;//Verifico si entra en el while nomas
				while(r.next()){
					i= i + 1;
					String codigo = r.getString("codigoaprobacion");
					if(!(codigo.equals(codigoAprob))){
						flag = true;//Señalo que el codigo no es igual
						mensaje = "Error de Validación. Código de Aprobación Incorrecto";
					}else{
						db.updateAprobCommonUser(true, email);
					}
				}
				if(i==0){
					flag = true;//Señalo que hubo un error
					mensaje = "Error de Validación. Email inexistente o incorrecto";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			flag = true;
			mensaje = "Ocurrio un error interno. Disculpe las molestias. Intente más tarde";
		}
		
		if(flag){
			//Si se produce algun error en la validación informo al usuario
			response.setContentType("text/html");
			request.setAttribute("validacion", "si");
			request.setAttribute("mensValid", mensaje);
			request.getRequestDispatcher("validacion.jsp").forward(request, response);
		}else{
			//Redirecciono al inicio. Aun que en un futuro tiene que ir a su perfil.
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
