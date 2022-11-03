package XMLReader;

import Serializacion2.Product2;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XmlReader {

    public static void leerXml(File file) throws FileNotFoundException, XMLStreamException {

        Product2 p = null;
        ArrayList<Product2> product = new ArrayList<>();

        XMLInputFactory inpXml = XMLInputFactory.newInstance();
        XMLStreamReader xml = inpXml.createXMLStreamReader(new FileInputStream(file));
        int elemento = 0;
        String contenido = "";
        String nombre = "";

        while (xml.hasNext()) {
            if ((elemento = xml.getEventType()) == XMLStreamConstants.START_ELEMENT) {
                contenido = xml.getLocalName();
                String atr = xml.getAttributeValue(0);
                if (contenido.equalsIgnoreCase("produto")) {
                    p = new Product2();
                } else if (contenido.equalsIgnoreCase("codigo")) {
                    nombre = xml.getElementText();
                    p.setCodigo(nombre);
                } else if (contenido.equalsIgnoreCase("descricion")) {
                    nombre = xml.getElementText();
                    p.setDescripcion(nombre);
                } else if (contenido.equalsIgnoreCase("prezo")) {
                    nombre = xml.getElementText();
                    p.setPrezo(Integer.parseInt(nombre));

                }
            } else if ((elemento = xml.getEventType()) == XMLStreamConstants.END_ELEMENT) {
                contenido = xml.getLocalName();
                if (contenido.equals("produto")) {
                    product.add(p);
                }
            }
            xml.next();

        }
        xml.close();
        for (int i = 0; i < product.size(); i++) {
            System.out.println(product.get(i));
        }
    }


    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        File file = new File("/home/dam2a/Escritorio/AD/Prueba/products.xml");
        leerXml(file);
    }
}

