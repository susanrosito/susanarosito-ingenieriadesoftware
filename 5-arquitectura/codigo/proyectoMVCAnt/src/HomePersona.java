package codificacion;

public class HomePersona {
	private static HomePersona instancia;
	private ListaContactos contactos;

	private HomePersona() {
		contactos = new ListaContactos();
		contactos.agregar(new Persona("Susana",22));
		contactos.agregar(new Persona("Roony",21));
		contactos.agregar(new Persona("Tati",20));
	}

	public static HomePersona getInstance() {
		if (instancia == null) {
			instancia = new HomePersona();
		}
		return instancia;
	}

	public Persona crearPersona() {
		return new Persona();
	}

	public void borrarPersona(int posicion) {
		contactos.borrar(posicion);
	}

	public void salvar(Persona persona) {
		this.contactos.agregar(persona);
	}

	public void actualizar(Persona persona) {
		// esta mal.
		this.contactos.getLista().remove(persona);
		this.salvar(persona);
	}

	public String imprimirListaDeContactos() {
		String StringDeLista = "";
		for (int posicion = 0; posicion < contactos.getLista().size(); posicion++) {
			Persona persona = contactos.getLista().get(posicion);
			StringDeLista = StringDeLista + "pos: " + posicion + " Contacto: "
					+ persona.getNombre();
		}
		return StringDeLista;
	}

	public ListaContactos getContactos() {
		return contactos;
	}

	public void setContactos(ListaContactos contactos) {
		this.contactos = contactos;
	}
}
