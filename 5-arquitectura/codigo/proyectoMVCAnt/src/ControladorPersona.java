package codificacion;

public class ControladorPersona {

	private Persona modelo;
	private HomePersona home;

	public ControladorPersona() {
		this.home = HomePersona.getInstance();
	}

	public void crearPersona(String nombre, int edad) {
		Persona persona = this.home.crearPersona();
		persona.setNombre(nombre);
		persona.setEdad(edad);
		this.setModelo(persona);
	}

	public Persona sacarPersona(int posicion) {
		Persona persona = this.home.getContactos().sacarPersona(posicion);
		this.setModelo(persona);

		return getModelo();
	}

	public void borrarPersona(int posicion) {
		this.home.borrarPersona(posicion);
	}

	public String imprimirListaDeHome() {
		return this.home.imprimirListaDeContactos();
	}

	public void guardar() {
		this.home.salvar(this.modelo);
	}

	public void actualizar() {
		this.home.actualizar(this.modelo);

	}

	public HomePersona getHome() {
		return home;
	}

	public void setHome(HomePersona home) {
		this.home = home;
	}

	public Persona getModelo() {
		return modelo;
	}

	public void setModelo(Persona modelo) {

		this.modelo = modelo;
	}

	public String getNombre() {
		return modelo.getNombre();
	}

	public void setNombreModelo(String nombre) {
		this.modelo.setNombre(nombre);
	}

	public int getEdad() {
		return modelo.getEdad();
	}

	public void setEdadModelo(int edad) {
		this.modelo.setEdad(edad);
	}

}
