package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InicioUsuario {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/proyectosupermark_final";
	static final String USER = "root";
	static final String PASS = "popy3382";
	
	public InicioUsuario() {
		
		
	}
	
	public void menu(Usuario usuario) throws SQLException {

		System.out.println("Bienvendo/a "+usuario.getNombre());
		Scanner entrada = new Scanner(System.in);	
		int opcion = 0;

		do {
		System.out.println("Que desea hacer? ");
		System.out.println("1 - Seleccionar productos\r\n"
				+ "2 - Ver carrito \r\n"
				+ "3 - Realizar pedido\r\n"
				+ "");
		
		opcion = entrada.nextInt();
		
		
		switch(opcion) {
		case 1 : 
			Connection conn = null;
			Statement stmt = null;
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Categorias disponibles: ");
			stmt = conn.createStatement();
			String sql;
			sql = "select * from categoria";
			ResultSet rs = 	stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				int id_categoria_prod = rs.getInt("id_categoria_prod");
				String nombre_categoria_prod = rs.getString("nombre_categoria_prod");
				System.out.println("codigo: "+id_categoria_prod);
				System.out.println("categoria: "+nombre_categoria_prod);
				
			}
			
			System.out.println("Ingrese el codigo de la categoria: ");
			int opc = entrada.nextInt();
			
			String sql2 = "select id_producto, nombre_prod, precio_prod "
					+ "from producto where id_categoria_prod = " + "'"+opc+"';";
			ResultSet rs2 = stmt.executeQuery(sql2);
			
			while(rs2.next()) {
				
				int id_producto = rs2.getInt("id_producto");
				String nombre_prod= rs2.getString("nombre_prod");
				double precio = rs2.getDouble("precio_prod");
				
				System.out.println("id: "+id_producto);
				System.out.println("nombre producto: "+nombre_prod);
				System.out.println("precio: "+precio);
				
			}
			
			System.out.println("Seleccione id del producto : ");
			int idSel = entrada.nextInt();
			System.out.println("Ingrese la cantidad de productos: ");
			int cantidad_prod = entrada.nextInt();
			
			String consultaStock = "Select * from producto "
					+ "where id_producto ="+"'"+idSel+"'";
			
			ResultSet rs3 = stmt.executeQuery(consultaStock);
			
			if(rs3.next()) {
				int id_producto = rs3.getInt("id_producto");
				String nombre_prod = rs3.getString("nombre_prod"); 
				int stock_prod = rs3.getInt("stock_prod");
				double precio_prod = rs3.getDouble("precio_prod");
				int id_categoria_prod = rs3.getInt("id_categoria_prod");
				
				
				if(stock_prod>cantidad_prod) {
					Producto product = new Producto(id_producto, nombre_prod,cantidad_prod,precio_prod,id_categoria_prod );
					usuario.agregaCarritoU(product);
					System.out.println("Producto agregado correctamente!");
					
				}
				else {
					System.out.println("No hay stock del producto");
				}
			}
			
			break;
		case 2: 
			System.out.println("Productos en el carrito: ");
			
			Carrito carrito = usuario.getCarrito();
			carrito.recorrerCarrito();
			
			break;
		case 3: 
			
		Carrito carrito2= usuario.getCarrito();
		carrito2.autorizarCompra(usuario);
			
		break;
		
		default: 
		System.out.println("opcion incorrecta");
		break;
		}
		
		} while(opcion != 0);
			
		}
	

}