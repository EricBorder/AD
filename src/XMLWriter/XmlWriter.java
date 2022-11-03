package XMLWriter;

import Serializacion2.Product2;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XmlWriter {

    public static void main(String[] args) {

        ObjectInputStream ois = null;
        XMLStreamWriter xsw = null;
        try {
            File f = new File("/home/dam2a/Escritorio/AD/Prueba/productosSerializacion2.txt");
            ois = new ObjectInputStream(new FileInputStream(f));

            Product2 p;
            p = (Product2) ois.readObject();

            XMLOutputFactory xmlo = XMLOutputFactory.newInstance();

            xsw = xmlo.createXMLStreamWriter(new FileWriter("/home/dam2a/Escritorio/AD/Prueba/products.xml"));

            xsw.writeStartDocument("1.0");
            xsw.writeStartElement("produtos");

            while (p != null) {
                xsw.writeStartElement("produto");
                xsw.writeStartElement("codigo");
                xsw.writeCharacters(p.getCodigo());
                xsw.writeEndElement();
                xsw.writeStartElement("descricion");
                xsw.writeCharacters(p.getDescripcion());
                xsw.writeEndElement();
                xsw.writeStartElement("prezo");
                xsw.writeCharacters(String.valueOf(p.getPrezo()));
                xsw.writeEndElement();
                xsw.writeEndElement();
                p = (Product2) ois.readObject();
            }

            xsw.writeEndElement();
            xsw.writeEndDocument();

        } catch (IOException | ClassNotFoundException | XMLStreamException ex) {
            Logger.getLogger(XmlWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
                xsw.close();
            } catch (IOException | XMLStreamException ex) {
                Logger.getLogger(XmlWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
