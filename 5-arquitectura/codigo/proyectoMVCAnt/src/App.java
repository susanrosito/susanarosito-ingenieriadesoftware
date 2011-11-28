package codificacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("localhost", 1234);
			BufferedReader serverIn = new BufferedReader(new InputStreamReader(
					cliente.getInputStream()));
			PrintStream serverOut = new PrintStream(cliente.getOutputStream());
			int acciones = 1;
			while (acciones < 3){
			// Accion a realizar
			String preg = serverIn.readLine();
			serverOut.println(""+acciones);
			
			// Decicion tomada
			String respuesta = serverIn.readLine();
			System.out.println(respuesta);
		
			
			switch (acciones) {
			case 1:
				String cons1 = serverIn.readLine();
				serverOut.println("Pedro");
				
				String cons2 = serverIn.readLine();
				serverOut.println("22");
				
				;break;
			case 2:
				String ingnom = serverIn.readLine();
				
				serverOut.println("0");
				
				String remnom = serverIn.readLine();
				
				serverOut.println("Pedrito");
				
				String edited = serverIn.readLine();
				
				serverOut.println(23);
				
				
				;break;
			case 3:
				String ingnom2 = serverIn.readLine();
				
				serverOut.println("0");
				
				
				;break;
			default:
				break;
			}
			acciones = acciones +1;
			}
			
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
