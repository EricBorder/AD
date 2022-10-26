package Serializacion2;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("/home/dam2a/Escritorio/AD/Prueba/productosSerializacion2.txt");
        Product2 producto1 = new Product2();
        Product2 producto2 = new Product2();
        Product2 producto3 = new Product2();
        Product2 producto4 = null;
        Product2 metodos = new Product2();
        Serializacion access = new Serializacion();
        Product2[] listaProductos = new Product2[4];
        listaProductos[0]= producto1;
        listaProductos[1]= producto2;
        listaProductos[2]= producto3;
        listaProductos[3]= producto4; // Meto el último objeto un nulo para dar la condición de fin al while del método en Serial
        metodos.escribirValores(file,listaProductos);
        access.escribirObjetos(file,listaProductos);

    }
}
