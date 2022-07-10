package proyecto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Carrito {

	private ArrayList<Producto> arrayProd;
	
	public Carrito() {
		
		this.arrayProd = new ArrayList<Producto>();
	}

	public void agregaProducto(Producto p) {
		this.arrayProd.add(p);
	}
	
	public void recorrerCarrito() {
		
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
	
	public void autorizarCompra(Usuario user) throws SQLException {
		String sql;
		double total=0;
		Calendar fecha = new GregorianCalendar();
		
		int anio = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    String fecha_pedido=anio+"-"+mes+"-"+dia;
	    
	    for (int i=0;i<this.arrayProd.size();i++) {
	    	total +=(arrayProd.get(i)).getPrecio()*arrayProd.get(i).getCantidad();
	    }
	    
	    String detalle = devuelveDetalle();
	 
			
		//sql = "insert into pedido values (null,"+
		//user.getId_usuario()+",'"+fechaActual+"','"+detalle+"',"+total+");";
			
		
		sql= "insert into pedido values (null,'"+
		fecha_pedido+",'"+total+"','"+user.getId_usuario()+"',"+detalle+");";
			
		Conexion conexion = new Conexion();
		conexion.realizaConsulta(sql);
		System.out.println("Compra cargada con exito!");
			
			
				
	}
}