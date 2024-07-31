package server;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Iniciando conexión");
            serverSocket = new ServerSocket(7001);
            System.out.println("Esperando conexiones en el puerto 7001...");

            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Conexión aceptada de: " + clientSocket.getInetAddress());

                    try (DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream())) {
                        String fileName = dataInputStream.readUTF();
                        System.out.println("Nombre del archivo recibido: " + fileName);

                        try (FileOutputStream fileOutputStream = new FileOutputStream("servidor_" + fileName)) {
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            while ((bytesRead = dataInputStream.read(buffer)) != -1) {
                                fileOutputStream.write(buffer, 0, bytesRead);
                            }
                            System.out.println("Archivo " + fileName + " recibido y guardado.");
                        }
                    }
                } catch (IOException ioe) {
                    System.out.println("Error al aceptar o manejar la conexión del cliente: " + ioe.getMessage());
                }
            }
        } catch (IOException ioe) {
            System.out.println("Error al crear el ServerSocket: " + ioe.getMessage());
            ioe.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el serverSocket: " + e.getMessage());
                }
            }
        }
    }
}
