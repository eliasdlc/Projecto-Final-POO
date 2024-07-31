package server;

import java.io.*;
import java.net.*;

import Logica.Tienda;

public class Servidor extends Thread {

	public static void main(String args[]) {
		ServerSocket sfd = null;
		try {
			System.out.println("Iniciando");
			sfd = new ServerSocket(7000);
			System.out.println("Aceptando Conexion de la ip: " + sfd.getInetAddress());
			
			while(true) {
				try {
					Socket nsfd = sfd.accept();
					System.out.println("Conexion aceptada de la ip: " + nsfd.getInetAddress());
					
					ObjectInputStream inputStream = new ObjectInputStream(nsfd.getInputStream());
					try {
						Tienda tienda = (Tienda)inputStream.readObject();
						System.out.println("Llego el respaldo");
					} catch (ClassNotFoundException e) {
					System.out.println("Error en conexion: " + e.getMessage());
				}
					
				} catch(IOException ioe) {
					System.out.println("Error: " + ioe);
				}
			}
		}catch (IOException ioe) {
			System.out.println("Comunicacion Rechazada" + ioe);
		} finally {
			if(sfd != null && !sfd.isClosed()) {
				try {
					sfd.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
