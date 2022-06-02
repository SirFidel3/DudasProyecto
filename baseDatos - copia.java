package proyectfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;


public class baseDatos {
	
	
	/*
	 * Login y register
	 * ---------------------------------------------------------------------------------------------------------------------------*/
	
	//register
	public static void insertUsuari(String dni ,String name, String surnames, String email, String password,String fechaNacimiento, String address, String card) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO cliente VALUES ('"+dni+"','"+name+"','"+surnames+"','"+email+"','"+password+"','"+fechaNacimiento+"','"+address+"', '"+card+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	//login
	public static String selectUsuaris(String email, String password) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM cliente WHERE email='"+email+"' and password='"+password+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<table border=\"1\">"
						+ "<tr>"
						+ "<th>email</th>"
						+ "<th>password</th>"
						+ "</tr>";
		
		while (rs.next()) {
			resultat = resultat 
						+"<tr>"
						+ "<td>"+rs.getString("email")+"</td>"
						+ "<td>"+rs.getString("password")+"</td>"
						+"</tr>";
		}
		resultat=resultat+"</table>";
		return resultat;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Usuario
	 * ---------------------------------------------------------------------------------------------------------------------------*/
	
	//Usuario/ Reservar citas
	
	//revisar si introduce correctamente el nombre y el empleado
		//Usuario añadir citas
		public static void añadirCita(String hora, String hospital, String nss, String nombre, String empleado, String motivo) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/proyectofinal";
			Connection con = DriverManager.getConnection(url, "root", "cicle");
			Statement st = con.createStatement();
			
			String query = "INSERT INTO citas VALUES ('"+hora+"','"+hospital+"','"+nss+"','"+nombre+"','"+empleado+"','"+motivo+"')";
			st.executeUpdate(query);
			
			st.close();
			con.close();
		}
		
		//revisar si se retorna correctamente el return
		//complemento añadir cita usuario
		public static String nombreCita(String nss) throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/proyectofinal";
			Connection con = DriverManager.getConnection(url, "root", "cicle");
			Statement st = con.createStatement();
			
			String query = "SELECT nombre FROM cliente where NumSS ='"+nss+"'";
			st.executeUpdate(query);
			
			st.close();
			con.close();
			return query;
		}
		
		//revisar si consigue un doctor alazar correctamente
		//complemento añadir cita usuario
		public static String doctorCita (String doctor) throws SQLException, ClassNotFoundException{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/proyectofinal";
			Connection con = DriverManager.getConnection(url, "root", "cicle");
			Statement st = con.createStatement();
			
			String query ="SELECT nombre FROM empleados where doctor = (SELECT ((RAND()*(10-1))+1) FROM empleados)";
			st.executeUpdate(query);
			
			st.close();
			con.close();
			return query;
		}
	
		
		
		
		
		
		
	//Usuario/ Perfil
	
	//perfilDelUsuario
	//envia correctamente los datos para complementarlo a mi javascript
	public static String perfilUsuario( String email) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM cliente WHERE email='"+email+"'";
		ResultSet rs = st.executeQuery(query);
		
		String perfil = "<table border=\"1\">"
				+ "<tr>"
				+ "<th>dni</th>"
				+ "<th>name</th>"
				+ "<th>surnames</th>"
				+ "<th>email</th>"
				+ "<th>password</th>"
				+ "<th>fechaNacimiento</th>"
				+ "<th>adress</th>"
				+ "<th>card</th>"
				+ "</tr>";

		while (rs.next()) {
			perfil = perfil 
						+"<tr>"
						+ "<td>"+rs.getString("dni")+"</td>"
						+ "<td>"+rs.getString("name")+"</td>"
						+ "<td>"+rs.getString("surnames")+"</td>"
						+ "<td>"+rs.getString("email")+"</td>"
						+ "<td>"+rs.getString("password")+"</td>"
						+ "<td>"+rs.getString("fechaNacimiento")+"</td>"
						+ "<td>"+rs.getString("adress")+"</td>"
						+ "<td>"+rs.getString("card")+"</td>"
						+"</tr>";
		}
		
		perfil= perfil+"</table>";
		
		return perfil;
	}
	
	//Usuario lista de citas en el perfil
	public static String citasPerfilUsuario (String nss) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM citas WHERE nss='"+nss+"'";
		ResultSet rs = st.executeQuery(query);
		
		String citas = "<table border=\"1\">"
				+ "<tr>"
				+ "<th>Hora</th>"
				+ "<th>Centro Medico</th>"
				+ "<th>Numero de la seguridad social</th>"
				+ "<th>Cliente</th>"
				+ "<th>Doctor</th>"
				+ "<th>Motivo</th>"
				+ "</tr>";

		while (rs.next()) {
			citas = citas 
						+"<tr>"
						+ "<td>"+rs.getString("fecha_y_hora")+"</td>"
						+ "<td>"+rs.getString("centroMedico")+"</td>"
						+ "<td>"+rs.getString("nss")+"</td>"
						+ "<td>"+rs.getString("cliente")+"</td>"
						+ "<td>"+rs.getString("doctor")+"</td>"
						+ "<td>"+rs.getString("motivo")+"</td>"
						+"</tr>";
		}
		
		citas = citas+"</table>";
		
		return citas;

	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Admin
	 * --------------------------------------------------------------------------------------------------------------------------*/
	
	
	
	
	//usuarios admin..................
	
	//admin eliminar usuarios
	public static void  aEliminarUsuario(String dni) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "DELETE FROM cliente WHERE dni='"+dni+"'";
		ResultSet rs = st.executeQuery(query);
	}
	
	//admin ver info usuario
	public static String adminInfoUsuarios(String dni) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM paisos WHERE dni='"+dni+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<table border=\"1\">"
				+ "<tr>"
				+ "<th>dni</th>"
				+ "<th>name</th>"
				+ "<th>surnames</th>"
				+ "<th>email</th>"
				+ "<th>password</th>"
				+ "<th>fechaNacimiento</th>"
				+ "<th>adress</th>"
				+ "<th>card</th>"
				+ "</tr>";
				
				
		while (rs.next()) {
			resultat = resultat 
						+"<tr>"
						+ "<td>"+rs.getString("dni")+"</td>"
						+ "<td>"+rs.getString("name")+"</td>"
						+ "<td>"+rs.getString("surnames")+"</td>"
						+ "<td>"+rs.getString("email")+"</td>"
						+ "<td>"+rs.getString("password")+"</td>"
						+ "<td>"+rs.getString("fechaNacimiento")+"</td>"
						+ "<td>"+rs.getString("adress")+"</td>"
						+ "<td>"+rs.getString("card")+"</td>"
						+"</tr>";
		}
		resultat=resultat+"</table>";
		return resultat;
	}
	
	
	
	
	
	//empleados admin ...............................................
	
	//admin añadir empleado
	public static void añadirEmpleado(String dni ,String name, String surnames, String telefono, String email,String id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "INSERT INTO empleados VALUES ('"+dni+"','"+name+"','"+surnames+"','"+telefono+"','"+email+"','"+id+"')";
		st.executeUpdate(query);
		
		st.close();
		con.close();
	}
	
	//admin eliminar empleado
	public static void  aEliminarEmpleado(String id) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "DELETE FROM empleados WHERE id='"+id+"'";
		ResultSet rs = st.executeQuery(query);
	}
	
	//admin ver empleado
	public static String adminInfoEmpleados(String id) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/proyectofinal";
		Connection con = DriverManager.getConnection(url, "root", "cicle");
		Statement st = con.createStatement();
		
		String query = "SELECT * FROM empleados WHERE id='"+id+"'";
		ResultSet rs = st.executeQuery(query);
		
		String resultat = "<table border=\"1\">"
				+ "<tr>"
				+ "<th>dni</th>"
				+ "<th>nombre</th>"
				+ "<th>apellidos</th>"
				+ "<th>tel</th>"
				+"<th>email</th>"
				+"<th>id</th>"
				+ "</tr>";
				
				
		while (rs.next()) {
			resultat = resultat 
						+"<tr>"
						+ "<td>"+rs.getString("dni")+"</td>"
						+ "<td>"+rs.getString("nombre")+"</td>"
						+ "<td>"+rs.getString("apellidos")+"</td>"
						+ "<td>"+rs.getString("tel")+"</td>"
						+ "<td>"+rs.getString("email")+"</td>"
						+ "<td>"+rs.getString("id")+"</td>"
						+"</tr>";
		}
		resultat=resultat+"</table>";
		return resultat;
	}
	
	
	
	
	
	
	//admin citas ......................................................
	

	
}