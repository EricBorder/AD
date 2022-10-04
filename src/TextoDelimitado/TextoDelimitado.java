package TextoDelimitado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class TextoDelimitado {
    String[] cod = {"p1", "p2", "p3"};
    String[] descripcion = {"parafusos", "cravos", "tachas"};
    Double[] prezo = {3.0, 4.0, 5.0};


    @Override
    public String toString() {
        return
                Arrays.toString(cod) +
                        Arrays.toString(descripcion) +
                        Arrays.toString(prezo);


    }

    public Product escribirLeerTexto(Product producto) throws IOException {
        int contador = 0;
        String datosGrabdos = null;
        PrintWriter printF = new PrintWriter("/home/dam2a/Escritorio/AD/Prueba/productos2.txt");
        BufferedReader bufeF = new BufferedReader(new FileReader("/home/dam2a/Escritorio/AD/Prueba/productos2.txt"));
        for (int i = 0; i < cod.length; i++) {
            printF.println(cod[i] + "\t" + descripcion[i] + "\t" + prezo[i]);
        }
        printF.close();

        while ((datosGrabdos = bufeF.readLine()) != null) {
            String[] datosLeidos = datosGrabdos.split("\t");
            producto.setCodigo(datosLeidos[0]);
            producto.setDescripcion(datosLeidos[1]);
            producto.setPrezo(Double.parseDouble(datosLeidos[2]));

            System.out.println("Código: " + producto.getCodigo() + "\n" +
                    "Descripción: " + producto.getDescripcion() + "\n" +
                    "Prezo: " + producto.getPrezo() + " €");

        }
        bufeF.close();
        return producto;

    }
    public static void main(String[] args) throws IOException {
        TextoDelimitado prueba = new TextoDelimitado();
        Product producto = new Product();
        prueba.escribirLeerTexto(producto);


    }
}
