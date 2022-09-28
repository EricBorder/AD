package CopyByTextImage2;

import java.io.*;

public class copiarArchivo {

    //Primer Ejercicio
    public copiarArchivo(String sourceFile, String destinationFile) {
        System.out.println("Desde: " + sourceFile); //Archivo.Archivo de origen
        System.out.println("Hacia: " + destinationFile); //Archivo.Archivo de detino

        try {
            File inFile = new File(sourceFile);
            File outFile = new File(destinationFile);

            FileInputStream in = new FileInputStream(inFile);
            FileOutputStream out = new FileOutputStream(outFile);

            int c;
            while ((c = in.read()) != -1)
                out.write(c);

            in.close();
            out.close();
        } catch (IOException e) {
            System.err.println("Hubo un error de entrada/salida!!!");
        }
    }


    public void main(String args[]) {
        if (args.length == 2)
            new copiarArchivo(args[0], args[1]);
        else
            System.out.println("Debe ingresar dos parametros");

    }
}