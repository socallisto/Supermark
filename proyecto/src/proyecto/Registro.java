package proyecto;

import java.sql.SQLException;
import java.util.Scanner;

	public class Registro {
		
		private String nombre_usuario;
		private String email_usuario;
		private String contrasenia_usuario;
		private int id_tipo_usuario;
		private boolean tiene_tarjeta;
		private String direccion_usuario;
		private String premio_registro; 
		
		public Registro() {
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Ingrese su nombre: ");
			this.nombre_usuario = teclado.next();
			
			
			System.out.println("Ingrese su email: ");
			this.email_usuario= teclado.next();
			
			System.out.println("Ingrese contrasenia: ");
			this.contrasenia_usuario= teclado.next();
			
			this.id_tipo_usuario=1;
			this.tiene_tarjeta= true;
			
			System.out.println("Ingrese su direccion: ");
			this.direccion_usuario= teclado.next();
			this.premio_registro= "si";
		}
		
		public Usuario validaDatos() throws SQLException {
		
		if(this.nombre_usuario!=""&&
		   this.email_usuario!=""&&this.contrasenia_usuario!=""&&this.direccion_usuario!=""&&this.premio_registro!="") { 
			
			String sql = "insert into usuario values(null,"+"'"+this.nombre_usuario+"',"+
			"'"+this.email_usuario+"',"+"'"+this.contrasenia_usuario+"',"+"1,true);";
					//+ ","+"',"+"'"+this.direccion_usuario+"',"+this.premio_registro+");";
			
			Conexion conexion = new Conexion();
			conexion.realizaConsulta(sql);
			System.out.println("Usuario cargado con exito!");
		}
		
		else {
			System.out.println("DATOS MAL INGRESADOS");
		}
		return null;
	}
		}
