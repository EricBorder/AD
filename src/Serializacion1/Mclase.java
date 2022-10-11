package Serializacion1;

import java.io.*;

public class Mclase implements Serializable {
    String nome;
    transient int numero1;

    double numero2;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
    public void escribirObxeto(Mclase obx, Mclase obxEs , File file) throws IOException, ClassNotFoundException {
        ObjectOutputStream outF = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream inpF = new ObjectInputStream(new FileInputStream(file));
        outF.writeObject(obx);
        outF.close();
        obxEs = (Mclase) inpF.readObject();
        System.out.println(obxEs.toString());
    }
    @Override
    public String toString() {
        return
                "nome= " + nome + "\n" +
                        "numero1= " + numero1 + "\n" +
                        "numero2= " + numero2;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Mclase prueba = new Mclase();
        Mclase objAEscribir = new Mclase();
        prueba.nome = "ola";
        prueba.numero1 = -7;

        prueba.numero2 = 2.7E10;
        prueba.escribirObxeto(prueba,objAEscribir,new File("/home/dam2a/Escritorio/AD/Prueba/serializacion.txt"));
    }

}
