package proyecto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {

	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner (System.in);
		System.out.println(" *~Supermark~* ");
		System.out.println("Seleccione una opcion: ");
		System.out.println("1 - Ingresar\n2 - Registrarse");
		int opcion=entrada.nextInt();

		if(opcion==1) {
		
		System.out.println("Introduzca email: ");
		String email_usuario=entrada.next();
		
		System.out.println("Introduzca contrasenia: ");
		String contrasenia_usuario=entrada.next();
		
		Login login = new Login (email_usuario,contrasenia_usuario);
		Usuario usuario = login.ingresar();
		
		if(usuario!=null) { 
			
	    if(usuario.getTipo_usuario()==1) {
		InicioUsuario inicioUsuario = new InicioUsuario();
			
			inicioUsuario.menu(usuario);
			}
		else {
			
			
			InicioAdmin inicioAdmin = new InicioAdmin();
	        Admin admin = null;
			inicioAdmin.menu(admin);
	    }
	
		}
		}
	    else {
		System.out.println("Realizar Registro");
		Registro registro1 = new Registro();
		registro1.validaDatos();
		}



}
}
