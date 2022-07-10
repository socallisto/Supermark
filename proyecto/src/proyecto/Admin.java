package proyecto;

public class Admin {
	private int id_usuario;
	private String nombre_usuario;
	private String email_usuario;
	private String contrasenia_usuario;
	private int tipo_usuario;
	private boolean tiene_tarjeta;
	private String direccion_usuario;
	private String premio_registro;
	private Carrito carrito;

	
	public Admin(int id_usuario, String nombre_usuario, String email_usuario, String contrasenia_usuario, int tipo_usuario,
			boolean tiene_tarjeta, String direccion_usuario, String premio_registro) {

		this.id_usuario = id_usuario;
		this.nombre_usuario = nombre_usuario;
		this.email_usuario = email_usuario;
		this.contrasenia_usuario = contrasenia_usuario;
		this.tipo_usuario = tipo_usuario;
		this.tiene_tarjeta = tiene_tarjeta;
		this.direccion_usuario = direccion_usuario;
        this.premio_registro =premio_registro;
		this.carrito = new Carrito();
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre() {
		return nombre_usuario;
	}
	public void setNombre(String nombre) {
		this.nombre_usuario = nombre;
	
	}
	public String getEmail() {
		return email_usuario;
	}
	public void setEmail(String email) {
		this.email_usuario = email;
	}
	public String getContrasenia() {
		return contrasenia_usuario;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia_usuario = contrasenia;
	}
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public boolean isTiene_tarjeta() {
		return tiene_tarjeta;
	}
	public void setTiene_tarjeta(boolean tieneTarjeta) {
		this.tiene_tarjeta = tieneTarjeta;
	}
    public String isdireccion_usuario() {
	    return direccion_usuario;
    }
    public void setdireccion_usuario(String direccion_usuario) {
	    this.direccion_usuario = direccion_usuario;
    }
    public String ispremio_registro() {
	    return premio_registro;
    }
    public void setpremio_registro(String premio_registro) {
	    this.premio_registro = premio_registro;
    }
	public Carrito getCarrito() {
		return carrito;
	}
	public void setCarrito(Carrito carrito) {
		this.carrito = carrito;
	}
	
	public void agregaCarritoU(Producto p) {
		this.carrito.agregaProducto(p);
	}
}
