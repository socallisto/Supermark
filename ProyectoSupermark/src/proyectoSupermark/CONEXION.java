package proyectoSupermark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CONEXION {
	public Connection conn=null; //lo agrego fuera xq esta en el try	
	
	public CONEXION() { //constructor 		
	final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";	
	final String DB_URL="jdbc:mysql://localhost:3306/supermark1";	
	final String USER="root";	
	final String PASS="popy3382";	
	//Statement stmt =null;
	
	
	try { 		
		Class.forName(JDBC_DRIVER);
		//System.out.println("Conectando a la bdd...");////////////////
		conn=DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(Exception e) {
			System.out.println("error, no se pudo acceder a la base de datos...");////////////
			}		
	}
public ResultSet devuelveConsulta(String sql) throws SQLException {
	//System.out.println("Creando consulta...");
	Statement stmt=conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	return rs;
	}
public void realizaConsulta(String sql) throws SQLException {
	///System.out.println("Creando Consulta");
	Statement stmt=conn.createStatement();
	stmt.executeUpdate(sql);
	}
}


