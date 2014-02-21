package listeners;

import conexionDB.ConexionDB;
import java.io.IOException;
import javax.servlet.*;

/**
 * Servlet implementation class InicioDBContextListener
 */
public class InicioDBContextListener implements ServletContextListener {
	private ConexionDB db;
	
	public void contextInitialized(ServletContextEvent event){
		ServletContext sc = event.getServletContext();
		db = new ConexionDB();
		try{
			db.openConexion();
		}catch(Exception e){
			e.printStackTrace();
		}
		sc.setAttribute("baseDeDatos",db);
	}
		
	public void contextDestroyed(ServletContextEvent event) {
		try{
			db.closeConexion();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
