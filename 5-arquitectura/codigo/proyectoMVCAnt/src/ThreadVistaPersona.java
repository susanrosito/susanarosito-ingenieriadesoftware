package codificacion;

public class ThreadVistaPersona extends Thread {

	private VistaPersona vistaPersona;
	
	public ThreadVistaPersona(VistaPersona vista) {
		this.vistaPersona = vista;
	}
	@Override
	public void run() {
	vistaPersona.crearConeccion();
		
	}
}
