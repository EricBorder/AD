package CopyByText;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ejercicio2 {
    //Método de escritura
    public void read() {
        try {
            FileInputStream fin = new FileInputStream("fich1.txt");
            int i = 0;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Método de lectura
    public void write() {
        try {
            FileOutputStream fout = new FileOutputStream("fich1.txt");
            String s = "holaaaaa que tal";
            byte b[] = s.getBytes(); //converting string into byte array
            fout.write(b);
            fout.close();
            System.out.println("escrito");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

