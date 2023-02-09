package ejercicio1;

import java.io.IOException;
import java.net.*;

public class GestorProcesos extends Thread{
	 DatagramSocket socket;
     DatagramPacket datagramaEntrada;
     int numSecreto;
     int num;
     
     public GestorProcesos(DatagramSocket socket, DatagramPacket datagramaEntrada, int numSecreto) {
         super();
         this.socket = socket;
         this.datagramaEntrada = datagramaEntrada;
         this.numSecreto = numSecreto;
     }
     @Override
     public void run() {
         realizarProceso();
     }
     public void realizarProceso() {
    	 try {
    		 String mensajeRecibido = new String(datagramaEntrada.getData()).trim();
    		 String sol = "";
    		 // Si el número introducido es igual al secreto lo mostramos
    		 if (Integer.parseInt(mensajeRecibido)==this.numSecreto){
    			 sol = "Es igual al número secreto";
    		 } else {
    			 // Si el número introducido es menor al secreto lo mostramos
    			 if(Integer.parseInt(mensajeRecibido)<this.numSecreto){
    				 sol = "Es menor al número secreto";
    		     // Si el número introducido es mayor al secreto lo mostramos
        		 }else
        			 sol = "Es mayor al número secreto";
    		 }
    		 byte[] mensajeEnviado = sol.getBytes();
    		 DatagramPacket packetSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,datagramaEntrada.getAddress(), datagramaEntrada.getPort());
             socket.send(packetSalida);
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}