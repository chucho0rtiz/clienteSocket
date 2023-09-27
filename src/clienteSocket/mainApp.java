package clienteSocket;
import java.net.*;
import java.util.Scanner;
import java.io.*;

public class mainApp {

	public static void main(String[] args) throws IOException {
		System.out.println("******Maquina cliente******");
		Scanner reader = new Scanner(System.in);
		boolean state = true;
		while(state) {
			int telefono = 0;
			String aceptar = "";
			
			System.out.println("¿Quiere consultar un número telefonico? ");
			System.out.println("Digite N para no o S para si");
			aceptar = reader.next();
			
			if (aceptar.equals("S") || aceptar.equals("s")) {
				System.out.println("Introduce un número de telefono: ");
				telefono = reader.nextInt();
				
				// se crea la conexion con el server
				Socket s = new Socket("192.168.1.1", 4444);
				
				// se envia una respuesta al server
				PrintWriter pr = new PrintWriter(s.getOutputStream());
				pr.println(telefono);
				pr.flush();
				
				// se recibe una respuesta del server 
				InputStreamReader in = new InputStreamReader(s.getInputStream());
				BufferedReader bf = new BufferedReader(in);
				String str = bf.readLine();
				System.out.println("Server: " + str + "\n");
				
			} else {
				// se crea la conexion con el server
				Socket s = new Socket("192.168.1.1", 4444);
				
				// se envia una respuesta al server
				PrintWriter pr = new PrintWriter(s.getOutputStream());
				pr.println(false);
				pr.flush();
				System.out.println("Cliente Close");
				state = false;
				break;
			}
		}
		
	}

}
