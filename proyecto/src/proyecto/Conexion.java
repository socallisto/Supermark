package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
	public Connection conn=null; 

	public Conexion() { 	
	final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	final String DB_URL="jdbc:mysql://localhost:3306/proyectosupermark_final";
	final String USER="root";
	final String PASS="popy3382";



	try {

		Class.forName(JDBC_DRIVER);	
		System.out.println("Conectandose a la base de datos ");
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		
	
	}catch(Exception e) {
		System.out.println("error, no se pudo acceder a la base de datos...");
	}	
	}
	
	public ResultSet devuelveConsulta(String sql) throws SQLException {
		
		System.out.println("Creando consulta...");
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		return rs;
	}
	
	public void realizaConsulta(String sql) throws SQLException {
		
		System.out.println("Creando Consulta");
		Statement stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		
		

	}
	
	
	
	
}