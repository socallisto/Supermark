package proyectoSupermark;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


import java.util.ArrayList;
//es la misma clase de usuario
public class Cliente {
	private int idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String domicilioCliente;
	private String emailCliente;
	private boolean tarjetaCliente;
	private boolean premioCliente;
	private int numcomprasCliente;
	private Listap listap;
	
	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String domicilioCliente, String emailCliente,boolean tarjetaCliente, boolean premioCliente, int numcomprasCliente) {
		this.idCliente=idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.domicilioCliente = domicilioCliente;
		this.emailCliente = emailCliente;
		this.tarjetaCliente = tarjetaCliente;
		this.premioCliente = premioCliente;
		this.numcomprasCliente = numcomprasCliente;
		this.listap = new Listap();
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}
	public String getDomicilioCliente() {
		return domicilioCliente;
	}
	public void setDomicilioCliente(String domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}
	public String getEmailCliente() {
		return emailCliente;
	}
	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	public boolean isTarjetaCliente() {
		return tarjetaCliente;
	}
	public void setTarjetaCliente(boolean tarjetaCliente) {
		this.tarjetaCliente = tarjetaCliente;
	}
	public boolean isPremioCliente() {
		return premioCliente;
	}
	public void setPremioCliente(boolean premioCliente) {
		this.premioCliente = premioCliente;
	}
	public int getNumcomprasCliente() {
		return numcomprasCliente;
	}
	public void setNumcomprasCliente(int numcomprasCliente) {
		this.numcomprasCliente = numcomprasCliente;
	}
	public Listap getListap() {
		return listap;
	}
	public void setListap(Listap listap) {
		this.listap = listap;
	}
	
	public void agregalistapU(Producto p) {
		this.listap.agregaProducto(p);
	}
 

		
	
	public void CrearListap() throws SQLException {
		ArrayList <Integer> arrproducto= new ArrayList<Integer>();
		ArrayList <Integer> cant= new ArrayList<Integer>();

		//int[] pc=new int[2];
		CONEXION conexion= new CONEXION();	
		Scanner entrada=new Scanner(System.in);
		int opc;
		int sumprod=0;
		
		do {
			System.out.println("Elige la opcion de categoria:\n 1.Lacteos\n 2.Limpieza\n 3.Bebidas\n 4.Frutas y Verduras\n 5.Alimentos\n 6.Terminar carrito");
			opc=entrada.nextInt();
			
			
			if(sumprod==30){
				System.out.println("Carrito lleno! :D ");
				opc=6;

			}
			else if(opc==6 && sumprod==0){
				System.out.println("Carrito vacio");
			}
			else if(opc==1|| opc==2 || opc==3 || opc==4 || opc==5 ) {

				entrada.nextLine();
				String nombreProducto=null;
				String sql2 = "SELECT idProducto, Nombre_Producto, Precio_Producto, Stock_Producto FROM producto WHERE categoria_idCategoria="+opc;
				ResultSet rs2 = conexion.devuelveConsulta(sql2);
				
				while(rs2.next()) {
					
					int idProducto = rs2.getInt("idProducto");
					nombreProducto= rs2.getString("Nombre_Producto");
					double precioProducto = rs2.getDouble("Precio_Producto");
					int stockProducto=rs2.getInt("Stock_Producto");
					System.out.println("Lista de productos:");
					System.out.println("id:"+idProducto+" nombre producto:"+nombreProducto+" precio:"+precioProducto+" stock:"+stockProducto);
					
				}
				if(nombreProducto==null) {
					System.out.println("Lo siento, no hay productos en esta categoria");

				}
				else {
					
					System.out.println("Seleccione id del producto : ");
					int idSel = entrada.nextInt();
					arrproducto.add(idSel);
					System.out.println("Ingrese la cantidad de productos: ");
					int cantP = entrada.nextInt();
					cant.add(cantP);
					sumprod+=cantP;
				}
				
			}
			else if(opc!=6){
				System.out.println("Opcion incorrecta, vuelve a intentarlo");
			}
			
		}while(opc!=6);
		
		entrada.nextLine();
		float total;
		
		if(sumprod>0){
			Listap listap=new Listap(arrproducto, cant);
			do {
				System.out.println("Como deseas continuar?\n 1.Calcular Total\n 2.Agregar productos\n 3.Eliminar productos\n 4.Confirmar Compra\n 5.Salir");
				opc=entrada.nextInt();
				
				switch(opc){
				case 1:
					total=listap.calcularTotal();
					System.out.println("Precio total del carrito:"+total);

					break;
				case 2:////////////////////////////AQUI FALTA agregar productos
					
					break;
				case 3: //////eliminar productos
					break;
				case 4: //confirmar compra 
					
					//total=listap.calcularTotal();
					//String sql = "INSERT INTO compra "
						//	+ "( Total_Compra, Cliente_idCliente) "
							//+ "VALUES ("+total+"','"+cliente.getIdCliente()+");";
									//','"+cliente.getICliente()+");" ;
					//conexion.realizaConsulta(sql);
					//System.out.println("Compra exitosa :D");
					break;
				case 5:
					System.out.println("Volviendo al menu");
					break;
				default:
					System.out.println("Opcion incorrecta, vuelve a intentarlo");
				
				}
			}while(opc!=5);
		}
	}
		
	//}	
		
		
			

}///NO SE TOCA LLAVE