package proyectoSupermark;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {
	public static void main(String[] args) {
		PruebaConexion conexion = new PruebaConexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");
			
			while (rs.next()) {
				int id_usuario = rs.getInt(1);
				String nombre_usuario = rs.getString(2);
				String email_usuario = rs.getString(3);
				
				System.out.println(id_usuario + " - " + nombre_usuario + " - " + email_usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (rs!= null) {
					rs.close();
				}
				
				if (stm != null) {
					stm.close();
				}
				
				if (cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}