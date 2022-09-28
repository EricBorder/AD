package CopyByTextImage2;

import java.io.*;

public class copiarImagen {

    public void copiarArchivo(String sourceFile, String destinationFile) {
        System.out.println("Desde: " + sourceFile);
        System.out.println("Hacia: " + destinationFile);

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
    BufferedInputStream vLectura;
    BufferedOutputStream vEscritura;
    FileInputStream archivo;
    FileOutputStream copiaArchivo;

    {
        try {
            archivo = new FileInputStream("foto.jpg");
            copiaArchivo = new FileOutputStream("foto2.jpg", true);
        } catch (FileNotFoundException e) {
            System.out.println("Archivo.Archivo non encontrado");
        }
    }

    public void copiarArchivoBuffer() {
        // con BufferedStream duplicamos velocidades.
        try {
            vLectura = new BufferedInputStream(archivo);
            vEscritura = new BufferedOutputStream(copiaArchivo);
            int contido;
            while ((contido = vLectura.read()) != -1) {
                vEscritura.write(contido);
            }
            vEscritura.close();
        } catch (IOException e) {
            System.out.println("Error en lectura archivo");

        }
    }

    }

