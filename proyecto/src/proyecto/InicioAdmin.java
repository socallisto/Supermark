package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InicioAdmin {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/proyectosupermark_final1";
	static final String USER = "root";
	static final String PASS = "popy3382";
	
	public InicioAdmin() {
		
	}

	public void menu(Admin admin) throws SQLException {
    System.out.println("Bienvenid@ admin");
	
    Scanner entrada = new Scanner(System.in);	
	int opcion = 0;

	
	System.out.println("Que desea hacer? ");
	System.out.println("1 - Cargar productos \r\n"
			+ "2 - Modificar productos \r\n"
			+ "3 - Ver usuarios que realizaron compras \r\n"
			+ "4 - Ver listado de productos seleccionados por usuarios \r\n"
			+ "");
	//opcion = entrada.nextInt();
	}}
//
	//switch(opcion) {
	//case 1 : 
		//Connection conn = null;
		//Statement stmt = null;
		//conn = DriverManager.getConnection(DB_URL, USER, PASS);
		//System.out.println("Modificar productos ");
		//stmt = conn.createStatement();
		//String sql;
		//sql = "insert into producto values (null,"+
		//producto.getid_producto()+",'"+producto.getNombre()+"',"+producto.getCantidad()+"',"+producto.getPrecio()+"',"+producto.getid_categoria_prod()+");";
		//ResultSet rs = 	stmt.executeQuery(sql);
		
		//while(rs.next()) {
			
			//int id_producto = rs.getInt("id_producto");
			//String nombre_prod = rs.getString("nombre_prod");
			//int stock_prod = rs.getInt(stock_prod);
			//int precio_prod = rs.getInt(precio_prod);
			//int id_categoria_prod = rs.getInt(id_categoria_prod);
			
			//System.out.println("codigo: "+id_categoria_prod);
			//System.out.println("categoria: "+nombre_categoria_prod);
			
		//}
		
		//System.out.println("Ingrese el codigo de la categoria: ");
		//int opc = entrada.nextInt();
		
		//String sql2 = "select id_producto, nombre_prod, precio_prod "
				//+ "from producto where id_categoria_prod = " + "'"+opc+"';";
		//System.out.println(sql2);
		//ResultSet rs2 = stmt.executeQuery(sql2);
		
		//while(rs2.next()) {
		//	
			//int id_producto = rs2.getInt("id_producto");
			//String nombre_prod= rs2.getString("nombre_prod");
			//double precio = rs2.getDouble("precio_prod");
			
			//System.out.println("id: "+id_producto);
			//System.out.println("nombre producto: "+nombre_prod);
			//System.out.println("precio: "+precio);
			
		//}
		
		//System.out.println("Seleccione id del producto : ");
		//int idSel = entrada.nextInt();
		//System.out.println("Ingrese la cantidad de productos: ");
		//int cantidad_prod = entrada.nextInt();
		
		//String consultaStock = "Select * from producto "
				//+ "where id_producto ="+"'"+idSel+"'";
		
		//System.out.println(consultaStock);
		//ResultSet rs3 = stmt.executeQuery(consultaStock);
		
		//if(rs3.next()) {
			//String nombre_prod = rs3.getString("nombre_prod"); 
			//int stock_prod = rs3.getInt("stock_prod");
			//double precio_prod = rs3.getDouble("precio_prod");
			
			
			//if(stock_prod>cantidad_prod) {
			    //instancio un producto con toda esa data ya que si hay stock de ese prod
				//Producto product = new Producto(nombre_prod,cantidad_prod,precio_prod);
				//usuario.agregaCarritoU(product); //agrego el producto al carrito asociado al usuario
				//System.out.println("Producto agregado correctamente!");
				
			//}
			//else {
			//	System.out.println("No hay stock del producto");
			//}
		//}
		
		//break;
	//case 2: 
		//System.out.println("Productos en el carrito: ");
		
		//Carrito carrito1 = usuario.getCarrito();
		//carrito1.recorrerCarrito();
		
		//break;
	//case 3: 
		
	///Carrito carrito2= usuario.getCarrito();
	//carrito2.autorizarCompra(usuario);
		
	//break;
	
	//default: 
	//System.out.println("opcion incorrecta");
	//break;
	//}
	
	//} while(opcion != 0);
		
	//}
//

//}
		
//}
//}

