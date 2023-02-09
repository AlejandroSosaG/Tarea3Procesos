package ejercicio1;

import java.io.IOException;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
    	DatagramSocket socket;
        try {
            socket = new DatagramSocket(42000);
            int numSecreto = (int)Math.random() *100;
            while (true) {
            	System.out.println("Creación del array de bytes");
                byte[] buffer = new byte[64];
                System.out.println("Creación del datagrama");
                DatagramPacket datagramaEntrada = new DatagramPacket(buffer, buffer.length);
                System.out.println("A la espera de recibir datagrama");
                socket.receive(datagramaEntrada);
                new GestorProcesos(socket, datagramaEntrada, numSecreto).start();
            }
        } catch (SocketException e) {
            System.out.println("Error al crear el Socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al recibir el paquete");
            e.printStackTrace();
        }
    }
}
