package PrimitiveWriteChars;

import java.io.*;

public class Primitivos2 {
    String cadena = "o tempo está xélido";
    int contador;

    public void escribirArchivo2() {
        try {
            DataOutputStream creado = new DataOutputStream(new FileOutputStream(new File("/home/dam2a/Escritorio/AD/Prueba/Prueba2.txt"),true));
            DataInputStream leido = new DataInputStream(new FileInputStream(new File("/home/dam2a/Escritorio/AD/Prueba/Prueba2.txt")));
            for (int i = 0; i < 3 ; i++) {
                creado.writeUTF(cadena);
            }
            creado.close();
            while ((contador = leido.available()) != 0){
                contador = leido.available();
                System.out.println("Escribiendo la cadena: " + leido.readUTF() + "\nBytes por leer: " + (contador) );
            }
            System.out.println("Lectura de archivo terminado");
        } catch (IOException e) {
            System.out.println("Error en proceso " + e.getMessage());

        }
    }
    public static void main(String[] args) {
        Primitivos2 prueba = new Primitivos2();
        prueba.escribirArchivo2();
    }
}

