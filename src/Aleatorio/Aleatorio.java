package Aleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio {

    String[] codes = {"p1", "p2", "p3"};
    String[] descripcion = {"parafusos", "cravos", "tachas"};
    int[] prices = {3, 4, 5};
    int formula = (2 - 1)*30; //Formula para leer la segunda posición (n-1)*30
    String codigoLeido = "";
    String descripLeido = "";
    int precioLeido;

    public void lecturaEscritura(File file, String modo) throws IOException {
        RandomAccessFile outF = new RandomAccessFile(file,modo);
        for (int i = 0; i < 3; i++) {
            outF.writeChars(String.format("%-" + 3 + "s", codes[i]).replace(' ', '0'));
            outF.writeChars(String.format("%-" + 10 + "s", descripcion[i]).replace(' ', '0'));
            outF.writeInt(prices[i]);

        }
        outF.seek(formula);
        for (int i = 0; i < 3; i++) {
            codigoLeido += String.valueOf(outF.readChar());
        }
        codigoLeido = codigoLeido.replaceAll("0", "");

        for (int i = 0; i < 10; i++) {
            descripLeido += String.valueOf(outF.readChar());
        }
        descripLeido = descripLeido.replaceAll("0", "");

        precioLeido = outF.readInt();
        System.out.println(codigoLeido + descripLeido + precioLeido);
        outF.close();
    }

    public static void main(String[] args) throws IOException {
        Aleatorio prueba = new Aleatorio();
        File file = new File("/home/dam2a/Escritorio/AD/Prueba/aleatorio.txt");
        prueba.lecturaEscritura(file,"rw");
    }
}
