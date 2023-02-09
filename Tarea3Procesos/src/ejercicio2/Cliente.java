package ejercicio2;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {
            Scanner sc = new Scanner(System.in);
            InetAddress direccion = InetAddress.getLocalHost();
            //Crear un socket de tipo cliente indicando IP y puerto del servidor
            Socket socket = new Socket(direccion, 42000);
            //Abrir flujos de lectura y escritura
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            // Pedimos una dirección web
            System.out.println("Introduzca una direccion web");
            String web = sc.nextLine();
            // Enviamos la dirección web introducida
            osw.write(web);
            bw.newLine();
            bw.flush();
            //Intercambiamos datos con el servidor
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(ir);
            System.out.println("El servidor envía el mensaje: " + br.readLine());
            sc.close();
            is.close();
            os.close();
            osw.close();
            bw.close();
            ir.close();
            br.close();
            socket.close();
        } catch (UnknownHostException e) {
            System.err.println("No se encuentra el host especificado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Se ha producido un error en la conexión con el servidor.");
            e.printStackTrace();
        }
	}
}
