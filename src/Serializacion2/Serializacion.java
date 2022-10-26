package Serializacion2;

import java.io.*;

public class Serializacion implements Serializable {
    public void escribirObjetos(File file, Product2[] productos) throws IOException, ClassNotFoundException {
        ObjectOutputStream outF = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream inpF = new ObjectInputStream(new FileInputStream(file));
        for (Product2 producto : productos) {
            outF.writeObject(producto);
        }
        outF.close();
        Product2 pr = null; // Declaro un Product con valor nulo para ir dando los valores de cada objeto grabado en fichero, y saber cuando llega al nulo.
        while ((pr = (Product2) inpF.readObject()) != null){
            System.out.println(pr);
        }
    }


}
