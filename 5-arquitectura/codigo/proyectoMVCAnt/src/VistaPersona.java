package codificacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;
import codificacion.ControladorPersona;
import sun.applet.Main;

public class VistaPersona implements Observer {

	private ControladorPersona controladorPersona;

	private ServerSocket servidorSocket;
	private Socket conexion;
	private PrintStream salidaServidor;
	private BufferedReader entradaServidor;
	private ListaContactos listaDeContactos;

	public VistaPersona(String nombre, ControladorPersona constroladorPersona) {
		this.setControladorPersona(constroladorPersona);
		this.listaDeContactos = controladorPersona.getHome().getContactos();
		this.listaDeContactos.addObserver(this);
	
	}

	protected void crearConeccion() {
		try {
			this.servidorSocket = new ServerSocket(1235);
			this.conexion = servidorSocket.accept();
			entradaServidor = new BufferedReader(new InputStreamReader(conexion
					.getInputStream()));
			salidaServidor = new PrintStream(conexion.getOutputStream());
			ejecutarServidor();
		} catch (Exception e) {
			System.out.println("el servidor ze callo. Porque aca termina el test");
		}
	}

	public void ejecutarServidor() throws Exception {
		String accion;
		while (true) {
			salidaServidor
					.println("Bienvenido  Esto es un ABM de Contactos de una agenda  Que accion desea realizar  "
							+ " 1)Crear un contacto  2) Editar Contacto  3)Borrar Contacto  Contactos: "
							+ controladorPersona.imprimirListaDeHome());
			accion = readLine();
			salidaServidor.println("Eligio la accion: " + accion);
			this.realizarAccion(accion);
		}
	}

	public void realizarAccion(String de) throws Exception {
		int valor = Integer.parseInt(de);
		switch (valor) {
		case 1:
			crearContacto();
			break;
		case 2:
			editarContacto();
			throw new Exception(); 
		case 3:
			borrarContacto();
			break;
		default:
			break;
		}
		
	}

	protected void crearContacto() {
		String nombre;
		int edad;
		salidaServidor.println("Ingrese Nombre:");
		nombre = readLine();
		salidaServidor.println("Ingrese edad:");
		edad = Integer.parseInt(readLine());
		controladorPersona.crearPersona(nombre, edad);
		controladorPersona.guardar();
	}
	
	protected void editarContacto() {
		int posicion;
		int edad;
		String nombre;
		salidaServidor.println("Ingrese posicion:");
		posicion = Integer.parseInt(readLine());
		Persona personaAEditar = controladorPersona.sacarPersona(posicion);
		this.controladorPersona.getModelo().addObserver(this);
		salidaServidor.println("Editar el nombre: " + personaAEditar.getNombre()
				+ " Ingresa el nombre:");
		nombre = readLine();
		salidaServidor.println("Editar el edad de la persona : "
				+ personaAEditar.getNombre()
				+ " Ingresa el nombre:");
		edad = Integer.parseInt(readLine());
		controladorPersona.setNombreModelo(nombre);
		controladorPersona.setEdadModelo(edad);
		controladorPersona.actualizar();
	}
	protected void borrarContacto() {
		int posicion;
		salidaServidor.println("Ingrese posicion del Contacto:");
		posicion = Integer.parseInt(readLine());
		controladorPersona.borrarPersona(posicion);
	}

	

	protected String readLine() {
		try {
			return entradaServidor.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Observable entidad, Object propiedadDeEntidad) {
		CambioPropiedad propiedad = (CambioPropiedad) propiedadDeEntidad;
		System.out.println("La propiedad " + propiedad.getPropiedad()
				+ " a sido modificada, del valor " + propiedad.getValorViejo()
				+ " a este valor " + propiedad.getValorNuevo());
	}

	public void setControladorPersona(ControladorPersona ctps) {
		this.controladorPersona = ctps;
	}

	public ControladorPersona getControladorPersona() {
		return controladorPersona;
	}


}
