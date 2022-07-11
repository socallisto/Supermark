package proyectoSupermark;

public class Producto {

	private int id_producto;
	private String nombre;
	private int cantidad;
	private double precio;
	private int id_categoria_prod;

	public Producto(int id_producto, String nombre,int cantidad, double precio, int id_categoria_prod) {
		super();
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.nombre = nombre;
		this.precio = precio;
		this.id_categoria_prod= id_categoria_prod;
		
	}
	public int getid_categoria_prod() {
		return id_categoria_prod;
	}
	public void setid_categoria_prod(int id_categoria_prod) {
		this.id_categoria_prod= id_categoria_prod;
	}
		
	public int getid_producto() {
		return id_producto;
	}
	public void setid_producto(int id_producto) {
		this.id_producto = id_producto;
	}
		

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "- Nombre del producto: " + nombre + " \n  Cantidad=" + cantidad + " \n  Precio=" + precio + "]";
	}
	
	
	
}
