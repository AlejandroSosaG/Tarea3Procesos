package ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor {

	public static void main(String[] args) {
		try {
            // Creación del socket de tipo servidor
            ServerSocket servidor = new ServerSocket(42000);
            InputStream is;
            BufferedReader br;
            InputStreamReader ir;
            String mensajeRecibido;
            Socket peticion;
            while (true) {
                peticion = servidor.accept();
                is = peticion.getInputStream();
                ir = new InputStreamReader(is);
                br = new BufferedReader(ir);
                // Leemos el mensaje del cliente
                mensajeRecibido = br.readLine();
                new GestorProcesos(mensajeRecibido, peticion).start();
            }
        } catch (IOException e) {
            System.err.println("Ha habido algún error en la creación del Socket Servidor");
            e.printStackTrace();
        }
    }
}
