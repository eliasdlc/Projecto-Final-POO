package server;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7001)) {
            System.out.println("Servidor esperando conexiones en el puerto 7001...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream())) {

                    ArrayList<Object> respaldo = (ArrayList<Object>) in.readObject();
                    System.out.println("ArrayList recibido: " + respaldo);

                    File file = new File("respaldo.dat");
                    
                    try (ObjectOutputStream fileOut = new ObjectOutputStream(new FileOutputStream(file))) {
                        fileOut.writeObject(respaldo);
                        System.out.println("Archivo respaldo.dat guardado exitosamente.");
                    }

                } catch (ClassNotFoundException | IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
