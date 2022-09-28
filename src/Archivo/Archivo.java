package Archivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Archivo {
    File StringPath;

    public Archivo() {
    }

    public Archivo(File stringPath) {
        StringPath = stringPath;
    }

    // EJERCICIO 1
    public static void eDirectorio(String directorio) {

        File f = new File(directorio);
        if (f.isDirectory()) {
            System.out.println("Es un directorio");
        } else {
            System.out.println("No es un directorio");
        }
    }

    // EJERCICIO 2
    public static void eFicheiro(String cadena) {
        File f = new File(cadena);
        if (f.isFile()) {
            System.out.println("Es un fichero");
        } else {
            System.out.println("No es un fichero");
        }
    }

    // EJERCICIO 3
    public static void creaDirectorio(String directorio) {
        File f = new File(directorio);
        if(f.exists()){
            System.out.println("No se ha creado directorio");
        }else{
            f.mkdirs();
            System.out.println("Se ha creado directorio");
        }

    }

    //EJERCICIO 4
    public static void creaFicheiro(String dirName, String fileName){
        File f = new File(dirName);
        if(f.isDirectory()){
            File a = new File(fileName);
            System.out.println("Directorio existe");
            try {
                if(a.createNewFile()){
                    System.out.println("Se ha creado directorio");
                } else{
                    System.out.println("No se ha creado directorio");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Directorio no existe");
        }
    }

    //EJERCICIO 5
    public static void modoAcceso (String dirName, String fileName){
        File f = new File(dirName);
        if(f.isDirectory()){
            File a = new File(fileName);
            System.out.println("Directorio existe");
            try {
                if(a.createNewFile()){
                    System.out.println("Se ha creado directorio");
                    if(a.canRead()){
                        System.out.println("Escritura sí");
                    } else{
                        System.out.println("Escritura no");
                    }
                    if(a.canWrite()){
                        System.out.println("Lectura sí");
                    } else{
                        System.out.println("Lectura no");
                    }
                } else{
                    System.out.println("No se ha creado directorio");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Directorio no existe");
        }
    }

    //EJERCICIO 6
    public static void calcularLonxitude(String dirName, String fileName){
        File f = new File(dirName);
        if(f.isDirectory()){
            File a = new File(fileName);
            System.out.println("Directorio existe");
            try {
                if(a.createNewFile()){
                    System.out.println("Se ha creado directorio");
                    a.getTotalSpace();
                } else{
                    System.out.println("No se ha creado directorio");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("Directorio no existe");
        }
    }

    //EJERCICIO 7
    public static void mLectura(String dirName, String fileName){
        File f = new File(dirName);
        if(f.isDirectory()){
            File a = new File(fileName);
            a.setReadOnly();
        }else{
            System.out.println("Directorio no existe");
        }
    }

    //EJERCICIO 8
    public static void mEscritura(String dirName, String fileName){
        File f = new File(dirName);
        if(f.isDirectory()){
            File a = new File(fileName);
            a.canWrite();
        }else{
            System.out.println("Directorio no existe");
        }
    }

    //EJERCICIO 9
    public static void borraFicheiro (String dirName, String fileName){
        File f = new File(dirName);
        if(f.isDirectory()){
            File a = new File(fileName);
            if(a.exists()){
                a.delete();
            } else{
                System.out.println("Fichero inexistente");
            }
        }else{
            System.out.println("Directorio no existe");
        }
    }

    //EJERCICIO 10
    public static void borraDirectorio(String dirName) {
        File f = new File(dirName);
        if(f.exists()){
            f.delete();
        }else{
            System.out.println("Ruta inexistente");
        }
    }

    //EJERCICIO 11
    public static void mContido(String dirName) {
        File f = new File(dirName);
        f.list();
    }

    //EJERCICIO 12
    public static void recur(File f) {
        f.listFiles();
    }
}
