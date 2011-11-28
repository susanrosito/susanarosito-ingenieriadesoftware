package codificacion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import junit.framework.TestCase;
import codificacion.VistaPersona;
import codificacion.ControladorPersona;


public class AppMvcTest extends TestCase {
	Socket cliente;
	BufferedReader serverIn;
	PrintStream serverOut;
	VistaPersona vista;
	int valor;
	
	@Override
	protected void setUp() throws Exception {
		ControladorPersona controlador = new ControladorPersona();
		vista = new VistaPersona("Prueba", controlador);
		new ThreadVistaPersona(vista).start();
		
		cliente = new Socket("localhost", 1235);
		serverIn = new BufferedReader(new InputStreamReader(
				cliente.getInputStream()));
		serverOut = new PrintStream(cliente.getOutputStream());
		

	}
	public void testDeberiaDeEditarNombreYEdadDePersonaApp() {
		
		int valor = 1;
		try {
			boolean realizoLaEdicion= false;
			while (! (realizoLaEdicion) && valor < 3 ) {
				// Accion a realizar
				String preg = serverIn.readLine();
				
				serverOut.println(""+valor);

				// Decicion tomada
				String respuesta = serverIn.readLine();
				System.out.println(respuesta);

				
				switch (valor) {
				case 1:
					String cons1 = serverIn.readLine();
					
					serverOut.println("Pedro");

					String cons2 = serverIn.readLine();
					
					serverOut.println("22");
					valor++;
					;
					break;
				case 2:
					String ingnom = serverIn.readLine();
					
					serverOut.println("0");

					String remnom = serverIn.readLine();
					
					serverOut.println("Pedrito");

					String edited = serverIn.readLine();
					
					serverOut.println("23");
					valor++;
					;
					break;
				case 3:
					String ingnom2 = serverIn.readLine();
					
					serverOut.println("0");

					;
					break;
				default:
					break;
					
					
				
				}
			
				
			}
		} catch (Exception e) {
			System.out.println("no realizo la edicion");
		}

	}
}
