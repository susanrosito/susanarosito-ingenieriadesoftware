package codificacion;

import java.util.Observable;

public class Persona extends Observable {

	private String nombre;
	private int edad;

	public Persona() {
	}

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		String nombreNuevo = nombre;
		String nombreViejo = this.nombre;

		this.nombre = nombreNuevo;

		setChanged();
		notifyObservers("nombre", nombreViejo, nombreNuevo);
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		int edadNueva = edad;
		int edadVieja = this.edad;

		this.edad = edadNueva;

		setChanged();
		notifyObservers("edad", edadVieja, edadNueva);
	}

	public void notifyObservers(String propiedad, Object valorViejo,
			Object valorNuevo) {
		super.notifyObservers(new CambioPropiedad(propiedad, valorViejo, valorNuevo));
	}

}
