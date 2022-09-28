package PrimitiveWriteUTF;

import java.io.*;

public class Primitivos {
    String cadena = "o tempo está xélido";
    int contador;

    public void escribirArchivo() {
        try {
            DataOutputStream archivoCreado = new DataOutputStream(new FileOutputStream(new File("/home/dam2a/Escritorio/AD/Prueba/Prueba.txt"),true));
            DataInputStream archivoLeido = new DataInputStream(new FileInputStream(new File("/home/dam2a/Escritorio/AD/Prueba/Prueba.txt")));
            for (int i = 0; i < 3 ; i++) {
                archivoCreado.writeUTF(cadena);
            }
            archivoCreado.close();
            while ((contador = archivoLeido.available()) != 0){
                contador = archivoLeido.available();
                System.out.println("Escribiendo la cadena: " + archivoLeido.readUTF() + "\nBytes por leer: " + (contador) );
            }
            System.out.println("\nLectura de archivoo terminado");
        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());

        }
    }
    public static void main(String[] args) {
        Primitivos prueba = new Primitivos();
        prueba.escribirArchivo();
    }
}
