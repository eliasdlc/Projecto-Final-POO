package server;

import java.io.*;
import java.net.*;

public class Servidor extends Thread {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            System.out.println("Iniciando conexión");
            serverSocket = new ServerSocket(7001);
            System.out.println("Esperando conexiones en el puerto 7000...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream())) {

                    System.out.println("Conexión aceptada de: " + clientSocket.getInetAddress());

                    // Leer el nombre del archivo
                    String fileName = dataInputStream.readUTF();
                    System.out.println("Nombre del archivo recibido: " + fileName);

                    // Preparar para escribir el archivo recibido
                    try (FileOutputStream fileOutputStream = new FileOutputStream("servidor_" + fileName)) {
                        byte[] buffer = new byte[4096];
                        int bytesRead;

                        // Leer el archivo y escribirlo en el servidor
                        while ((bytesRead = dataInputStream.read(buffer)) != -1) {
                            fileOutputStream.write(buffer, 0, bytesRead);
                        }

                        System.out.println("Archivo " + fileName + " recibido y guardado.");
                    }

                } catch (EOFException e) {
                    System.out.println("Archivo recibido completamente.");
                } catch (IOException ioe) {
                    System.out.println("Error en la comunicación con el cliente: " + ioe.getMessage());
                }
            }
        } catch (IOException ioe) {
            System.out.println("Comunicación rechazada: " + ioe.getMessage());
            System.exit(1);
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
