package ProductStream;

import java.io.*;

public class Product {
    private String codigo;
    private String descripcion;
    private Double prezo;
    public static DataOutputStream outputF;
    public static DataInputStream inputF;


    public Product() {
        this.codigo = "";
        this.descripcion = "";
        this.prezo = 0.00;

    }

    public Product(String codigo, String descripcion, Double prezo) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.prezo = prezo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrezo(Double prezo) {
        this.prezo = prezo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Double getPrezo() {
        return prezo;
    }

    @Override
    public String toString() {
        return codigo + descripcion + (Double) prezo;
    }

    public void escribirValores(Product product) throws IOException {
        outputF.writeUTF(product.getCodigo());
        outputF.writeUTF(product.getDescripcion());
        outputF.writeDouble(product.getPrezo());
    }

    public void leerValores() throws IOException {
        int contador;
        Product po3 = new Product();
        while ((contador = inputF.available()) != 0) {
            po3.setCodigo(inputF.readUTF());
            po3.setDescripcion(inputF.readUTF());
            po3.setPrezo(inputF.readDouble());
            System.out.println(po3.getCodigo() + ", " + po3.getDescripcion() + "," + po3.getPrezo());
        }
    }


    public static void main(String[] args) throws IOException {
        File file = new File("/home/dam2a/Escritorio/AD/Prueba/productos.txt");
        outputF = new DataOutputStream(new FileOutputStream(file));
        inputF = new DataInputStream(new FileInputStream(file));

        Product product = new Product("cod1", "parafusos", 3.0);
        product.escribirValores(product);

        Product product1 = new Product("cod2", "cravos", 4.0);
        product1.escribirValores(product1);
        outputF.close();
        while (inputF.available() != 0) {
            product.leerValores();
        }
        inputF.close();

    }

}
