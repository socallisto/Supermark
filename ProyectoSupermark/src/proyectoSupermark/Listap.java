package proyectoSupermark;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;






public class Listap {
	ArrayList <Integer> idProducto;
	ArrayList <Integer> cantidad;
	private ArrayList<Producto> arrayProd;
	int idCarrito;
	float total=0;
	
	
	


	public Listap(ArrayList<Integer> idProducto, ArrayList<Integer> cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public ArrayList<Integer> getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(ArrayList<Integer> idProducto) {
		this.idProducto = idProducto;
	}
	public ArrayList<Integer> getCantidad() {
		return cantidad;
	}
	public void setCantidad(ArrayList<Integer> cantidad) {
		this.cantidad = cantidad;
	}
	public int getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(int idCarrito) {
		this.idCarrito = idCarrito;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}


	public float calcularTotal() throws SQLException {
		CONEXION conexion= new CONEXION();
		int id;
		float precio=0;
		int cant;
		float calculo=0;
		
		for(int i=0; i<this.idProducto.size(); i++) {
			id=this.idProducto.get(i);

			String sql2 = "SELECT Precio_Producto FROM producto WHERE idProducto="+id+";";
			ResultSet rs2 = conexion.devuelveConsulta(sql2);
			
			while(rs2.next()) {
				precio=rs2.getFloat("Precio_Producto");	
			}
			System.out.println("precio: "+precio);

			cant=cantidad.get(i);
			System.out.println("cantidad: "+cant);

			calculo+=precio*cant;

		}
		this.total=calculo;
		return calculo;
	}
	///PARA METODO DE AGREGAR
public Listap() {
		
		this.arrayProd = new ArrayList<Producto>();
	}

	public void agregaProducto(Producto p) {
		this.arrayProd.add(p);
	}
		public void recorrerListap() {
			
			for (int i=0;i<this.arrayProd.size();i++) {
				
			System.out.println(arrayProd.get(i).toString());
			}
			}
		public String devuelveDetalle() {
				
		    	String cadena = "";
				for (int i=0;i<this.arrayProd.size();i++) {
					
				    cadena = cadena+arrayProd.get(i).toString()+"\n";
					
				}
				
				return cadena;
		}
	//PARA METODO DE ELIMINAR
			
								
	//PARA CONFIRMAR
	
}
//}