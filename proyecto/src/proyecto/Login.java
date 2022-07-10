package proyecto;
import java.sql.*;

public class Login {
	
	private String email_usuario;
	private String contrasenia_usuario;
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/proyectosupermark_final";
	static final String USER = "root";
	static final String PASS = "popy3382";
	
	public Login(String email_usuario, String contrasenia_usuario) {
		
		this.email_usuario = email_usuario;
		this.contrasenia_usuario = contrasenia_usuario;
	}
	
	
	public Usuario ingresar() throws SQLException {
		
		Usuario usuario = null;
		
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER); 
			System.out.println("Conectando a la base de datos..");
			
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Conectando sentencias..");
			stmt = conn.createStatement();
			String sql;
		    sql = "SELECT * FROM usuario WHERE email_usuario="+"'"+
	this.email_usuario+"'"+" and contrasenia_usuario="+"'"+this.contrasenia_usuario+"'";
		
		ResultSet rs= stmt.executeQuery(sql);
		
		while(rs.next()) {
			System.out.println("Ingreso Exitoso!");
			
			int id_usuario=rs.getInt("id_usuario");
			String nombre_usuario=rs.getString("nombre_usuario");
			String email_usuario=rs.getString("email_usuario");
			String contrasenia=rs.getString("contrasenia_usuario");	
			int id_tipo_usuario=rs.getInt("id_tipo_usuario");
			boolean tiene_tarjeta=rs.getBoolean("tiene_tarjeta");	
			String direccion_usuario=rs.getString("direccion_usuario");	
			String premio_registro= rs.getString("premio_registro");
			usuario = new Usuario (id_usuario, nombre_usuario,email_usuario, contrasenia, id_tipo_usuario,tiene_tarjeta, direccion_usuario, premio_registro);
		}
		rs.close();
		stmt.close();
		conn.close();
		} catch (SQLException se) { 
		se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt!= null)
					stmt.close();
			} catch(SQLException se2) {
			}
			try {
				if(conn!=null)
					conn.close();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
			return usuario;
		} 

	public String getEmail() {
		return email_usuario;
	}
	public void setEmail(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getContrasenia() {
		return contrasenia_usuario;
	}
	public void setContrasenia(String contrasenia_usuario) {
		this.contrasenia_usuario = contrasenia_usuario;
	}
	
}