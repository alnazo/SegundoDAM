import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

enum Genero{ mujer, hombre }

public class XMLCreator {

    private static Document doc;

    public XMLCreator() throws ParserConfigurationException {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        doc = b.newDocument();
    }

    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
        new XMLCreator();

        Element root = doc.createElement("personas");

        Element p1 = anadirPersona(doc, "cantante", "Elsa", Genero.mujer, 18, 6, 1996, "Pamplona");
        Element p2 = anadirPersona(doc, "escritor", "Julio Verne", Genero.hombre, 8, 2, 1828, "Nantes");

        root.appendChild(p1);
        root.appendChild(p2);

        generarXML(doc);

    }

    public static Element anadirPersona(Document doc, String profesion, String nombre, Genero genero, int dia, int mes, int anno, String ciudad){
        Element persona = doc.createElement("persona");
        persona.setAttribute("profesion", profesion);

        Element nom = doc.createElement("nombre");
        nom.setTextContent(nombre);
        persona.appendChild(nom);

        Element gen = doc.createElement(genero.toString());
        persona.appendChild(gen);

        Element fecha = doc.createElement("fecha_de_nacimiento");
        Element day = doc.createElement("dia");
        day.setTextContent(Integer.toString(dia));
        Element month = doc.createElement("mes");
        month.setTextContent(Integer.toString(mes));
        Element year = doc.createElement("año");
        year.setTextContent(Integer.toString(anno));

        persona.appendChild(fecha);
        fecha.appendChild(day);
        fecha.appendChild(month);
        fecha.appendChild(year);

        Element city = doc.createElement("ciudad");
        city.setTextContent(ciudad);
        persona.appendChild(city);

        return persona;
    }

    public static void generarXML(Document doc) throws TransformerException, IOException {
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();

        Source source = new DOMSource(doc);
        File file = new File("C:\\Users\\Antonio\\Desktop\\prueba.xml");
        FileWriter fw = new FileWriter (file);
        PrintWriter pw = new PrintWriter (fw);
        Result r = new StreamResult(pw);

        transformer.transform(source, r);
    }




}
