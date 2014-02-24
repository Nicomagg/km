package listeners;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import conexionDB.ConexionDB;

/**
 * Servlet implementation class DBContextListener
 */
public class DBContextListener implements ServletContextListener {
	private ConexionDB db;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try{
			db.closeConexion();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		try{
			ServletContext sc = event.getServletContext();
			db = new ConexionDB();
			db.openConexion();
			sc.setAttribute("BaseDeDatos", db);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
