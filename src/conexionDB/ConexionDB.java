package conexionDB;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionDB {
	
	private Connection conn = null;
	private ResultSet r = null;
	private PreparedStatement pst = null;
	private int st = 0;
	
	//opens the connection to the database
	public void openConexion(){
		try {			
			String driver = "org.postgresql.Driver";
			Class.forName(driver);
			conn  = DriverManager.getConnection(
		 	"jdbc:postgresql://localhost:5432/proyectoFinal", "postgres",
		 	"nico");
		} catch (SQLException e) {
		 	// TODO Auto-generated catch block
		 	e.printStackTrace();
		} catch (ClassNotFoundException e) {
		 	// TODO Auto-generated catch block
		 	e.printStackTrace();
		}
	}
	
	//closes the connection to the database
	public void closeConexion(){
		try {
			if (r != null) { 
				r.close();
 			}
			if (pst != null){
				pst.close();
			}
 			if (conn != null) { 
 				conn.close();
 			}		
		} catch (Exception e) {
			e.printStackTrace();
 		}
	}
	
	//add new admin
	public void newAdministrador(String email, String contrasena, String nombre, String apellido) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO administradores (email,contrasena,nombre,apellido)"
				+ "VALUES (?, ?, ?, ?)");
		pst.setString(1, email);
		pst.setString(2, contrasena);
		pst.setString(3, nombre);
		pst.setString(4, apellido);
		st = pst.executeUpdate();
	}
	
	//delete admin
	public void deleteAdministrador(int id) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM administradores"
				+ "WHERE idadmin = ?");
		pst.setInt(1, id);
		st = pst.executeUpdate();
	}
	
	//search a admin for name
	public ResultSet searchAdministradorForName(String nombre) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"administradores\""
	 	+ "WHERE nombre = ?");
		pst.setString(1, nombre);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a admin for surname
	public ResultSet searchAdministradorForSurname(String apellido) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"administradores\""
	 	+ "WHERE apellido = ?");
		pst.setString(1, apellido);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a admin for surname
	public ResultSet searchAdministradorForEmail(String email) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"administradores\""
	 	+ "WHERE email = ?");
		pst.setString(1, email);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new comment
	public void newComment(String texto, String fecha, String hora, boolean aprobacion) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO comentarios (texto, fecha, hora, aprobacion)"
				+ "VALUES (?, ?, ?, ?)");
		pst.setString(1, texto);
		pst.setString(2, fecha);
		pst.setString(3, hora);
		pst.setBoolean(4, aprobacion);
		st = pst.executeUpdate();
	}
	
	//delete comment
	public void deleteComment(int id) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM comentarios"
				+ "WHERE idcomen = ?");
		pst.setInt(1, id);
		st = pst.executeUpdate();
	}
	
	//search a comment for date
	public ResultSet searchCommentForDate(String fecha) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"comentarios\""
	 	+ "WHERE fecha = ?");
		pst.setString(1, fecha);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a comment for time
	public ResultSet searchCommentForTime(String hora) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"comentarios\""
	 	+ "WHERE hora = ?");
		pst.setString(1, hora);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new commerce
	public void newCommerce(String email, String contrasena, String nombre, String apellido, int cuit, String nomNegocio, String direccion, int telefono, int fotoPerfil, int puntuacion) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO comercios (email, contrasena, nombre, apellido, cuit, nombrenegocio, direccion, telefono, fotoperfil, puntuacion)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		pst.setString(1, email);
		pst.setString(2, contrasena);
		pst.setString(3, nombre);
		pst.setString(4, apellido);
		pst.setInt(5, cuit);
		pst.setString(6, nomNegocio);
		pst.setString(7, direccion);
		pst.setInt(8, telefono);
		pst.setInt(9, fotoPerfil);
		pst.setInt(10, puntuacion);
		st = pst.executeUpdate();
	}
	
	//delete commerce
	public void deleteCommerce(int cuit) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM comercios"
				+ "WHERE cuit = ?");
		pst.setInt(1, cuit);
		st = pst.executeUpdate();
	}
	
	//search a commerce for name
	public ResultSet searchCommercetForName(String nombreNegocio) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"comercios\""
	 	+ "WHERE nombrenegocio = ?");
		pst.setString(1, nombreNegocio);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a commerce for address
	public ResultSet searchCommercetForAddress(String direccion) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"comercios\""
	 	+ "WHERE direccion = ?");
		pst.setString(1, direccion);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new image
	public void newImage(String imagen) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO imagenes (imagen)"
				+ "VALUES (?)");
		pst.setString(1, imagen);
		st = pst.executeUpdate();
	}
	
	//delete image
	public void deleteImage(int idImg) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM imagenes"
				+ "WHERE idimg = ?");
		pst.setInt(1, idImg);
		st = pst.executeUpdate();
	}
	
	//search a image
	public ResultSet searchImage(int idImg) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"imagenes\""
	 	+ "WHERE idimg = ?");
		pst.setInt(1, idImg);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a image
	public int searchIdImage(String nombre) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"imagenes\""
	 	+ "WHERE imagen = ?");
		pst.setString(1, nombre);
		r = pst.executeQuery();
		int id = 0;
		while (r.next()) {
		 	 id = r.getInt("idimg");
		}
		return id;
	}
	
	//add new order
	public void newOrder(int comercio, String fecha, String hora, boolean aprobacion, int usuarioComun) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO pedidos (comercio, fecha, hora, aprobacion, usuariocomun)"
				+ "VALUES (?, ?, ?, ?, ?)");
		pst.setInt(1, comercio);
		pst.setString(2, fecha);
		pst.setString(3, hora);
		pst.setBoolean(4, aprobacion);
		pst.setInt(5, usuarioComun);
		st = pst.executeUpdate();
	}
	
	//delete order
	public void deleteOrder(int idped) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM pedidos"
				+ "WHERE idped = ?");
		pst.setInt(1, idped);
		st = pst.executeUpdate();
	}
	
	//search a order for id
	public ResultSet searchOrderForId(int idPed) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"pedidos\""
	 	+ "WHERE idPed = ?");
		pst.setInt(1, idPed);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a order for commerce
	public ResultSet searchOrderForCommerce(int comercio) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"pedidos\""
	 	+ "WHERE comercio = ?");
		pst.setInt(1, comercio);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a order for date
	public ResultSet searchOrderForDate(String fecha) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"pedidos\""
	 	+ "WHERE fecha = ?");
		pst.setString(1, fecha);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a order for time
	public ResultSet searchOrderForTime(String hora) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"pedidos\""
	 	+ "WHERE hora = ?");
		pst.setString(1, hora);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a order for user
	public ResultSet searchOrderForUser(int usuarioComun) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"pedidos\""
	 	+ "WHERE usuariocomun = ?");
		pst.setInt(1, usuarioComun);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new produce
	public void newProduce(int codigo, String nombre, String descripcion, int imgProducto) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO productos (codigo, nombre, descripcion, imgproducto)"
				+ "VALUES (?, ?, ?, ?)");
		pst.setInt(1, codigo);
		pst.setString(2, nombre);
		pst.setString(3, descripcion);
		pst.setInt(4, imgProducto);
		st = pst.executeUpdate();
	}
	
	//delete produce
	public void deleteProduce(int codigo) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM productos"
				+ "WHERE codigo = ?");
		pst.setInt(1, codigo);
		st = pst.executeUpdate();
	}
	
	//search a produce for id
	public ResultSet searchProduceForId(int codigo) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"productos\""
	 	+ "WHERE codigo = ?");
		pst.setInt(1, codigo);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a produce for name
	public ResultSet searchProduceForName(String nombre) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"productos\""
	 	+ "WHERE nombre = ?");
		pst.setString(1, nombre);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new order for produce
	public void newOrdForProd(int pedido, int producto) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO prodxped (pedido, producto)"
				+ "VALUES (?, ?)");
		pst.setInt(1, pedido);
		pst.setInt(2, producto);
		st = pst.executeUpdate();
	}
	
	//delete order for produce
	public void deleteOrdForProd(int id) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM prodxped"
				+ "WHERE idproxped = ?");
		pst.setInt(1, id);
		st = pst.executeUpdate();
	}
	
	//search a order for produce for id
	public ResultSet searchOrdForProdForId(int id) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"prodxped\""
	 	+ "WHERE idproxped = ?");
		pst.setInt(1, id);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a order for produce for order
	public ResultSet searchOrdForProdForOrder(int pedido) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"prodxped\""
	 	+ "WHERE pedido = ?");
		pst.setInt(1, pedido);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a order for produce for produce
	public ResultSet searchOrdForProdForProduce(int producto) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"prodxped\""
	 	+ "WHERE producto = ?");
		pst.setInt(1, producto);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new user
	public void newUser(String email, String contrasena, String nombre, String apellido) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO usuario (email, contrasena, nombre, apellido)"
				+ "VALUES (?, ?, ?, ?)");
		pst.setString(1, email);
		pst.setString(2, contrasena);
		pst.setString(3, nombre);
		pst.setString(4, apellido);
		st = pst.executeUpdate();
	}
	
	//delete user
	public void deleteUser(String email) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM usuario"
				+ "WHERE email = ?");
		pst.setString(1, email);
		st = pst.executeUpdate();
	}
	
	//search a user for email
	public ResultSet searchUserForEmail(String email) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"usuario\""
	 	+ "WHERE email = ?");
		pst.setString(1, email);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a user for name
	public ResultSet searchUserForName(String nombre) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"usuario\""
	 	+ "WHERE nombre = ?");
		pst.setString(1, nombre);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a user for surname
	public ResultSet searchUserForSurname(String apellido) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"usuario\""
	 	+ "WHERE apellido = ?");
		pst.setString(1, apellido);
		r = pst.executeQuery();
	 	return r;
	}
	
	//add new common user
	public void newCommonUser(String email, String contrasena, String nombre, String apellido, String direccion, String tel, int fotoPerfil, boolean aprobacion, String codigoAprobacion) throws SQLException{
		pst = conn.prepareStatement("INSERT INTO usuariocomun (email, contrasena, nombre, apellido, direccion, fotoperfil, aprobacion, codigoaprobacion, telefono)"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
		long telefono = 0;
		try {
		   telefono = Long.parseLong(tel);
	   }catch (NumberFormatException e){
	       System.out.println("not a number"); 
	   }
		pst.setString(1, email);
		pst.setString(2, contrasena);
		pst.setString(3, nombre);
		pst.setString(4, apellido);
		pst.setString(5, direccion);
		pst.setInt(6, fotoPerfil);
		pst.setBoolean(7, aprobacion);
		pst.setString(8, codigoAprobacion);
		pst.setLong(9, telefono);
		st = pst.executeUpdate();
	}
	
	//delete common user
	public void deleteCommonUser(int id) throws SQLException{
		pst = conn.prepareStatement("DELETE FROM usuariocomun"
				+ "WHERE iduc = ?");
		pst.setInt(1, id);
		st = pst.executeUpdate();
	}
	
	//search a common user for email
	public ResultSet searchCommonUserForEmail(String email) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"usuariocomun\""
	 	+ "WHERE email = ?");
		pst.setString(1, email);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a common user for name
	public ResultSet searchCommonUserForName(String nombre) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"usuariocomun\""
	 	+ "WHERE nombre = ?");
		pst.setString(1, nombre);
		r = pst.executeQuery();
	 	return r;
	}
	
	//search a common user for surname
	public ResultSet searchCommonUserForSurname(String apellido) throws SQLException{
		pst = conn.prepareStatement(
	 	"SELECT *"
	 	+ "FROM \"usuariocomun\""
	 	+ "WHERE apellido = ?");
		pst.setString(1, apellido);
		r = pst.executeQuery();
	 	return r;
	}
}
