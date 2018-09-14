import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;

import com.sun.javafx.runtime.SystemProperties;

import org.xml.sax.SAXException;


public class FactParser extends XMLParser {

    private FactRepository factRepository;
    


public FactParser() {
    this.factRepository = new FactRepository();
    Document FactDoc = this.loadXMLDocument("facts.xml");
    Element element = FactDoc.getDocumentElement();

    String id;
    String description;
    

    NodeList nodes = element.getChildNodes();

    Fact fact = new Fact("","");
    
    for (int i = 0; i < nodes.getLength(); i++) {
        
        Node node = nodes.item(i);

        if (node instanceof Element) {

            Element child = (Element) node;
            id = child.getAttribute("id");
            
           
            NodeList childList = child.getChildNodes();
           
            for (int j = 0; j < childList.getLength(); j++) {
                Node childNode = childList.item(j);

                if (childNode instanceof Element) {
                    Element childElement = (Element) childNode;
                    description = childElement.getAttribute("value");
                    
                    if (!description.equals("")) {
                        fact = new Fact(id, description);

                    }
                    
                   
                    
                    
                    NodeList evalsList = childElement.getChildNodes();
               

                    for (int k = 0; k < evalsList.getLength(); k++) {

                        Node evalsNode = evalsList.item(k);

                        if (evalsNode instanceof Element) {
                            Element evalsElement = (Element) evalsNode;
                            String factId = evalsElement.getAttribute("id");
                            System.out.println("to jest id faktu: " + factId);
                            String valueString = evalsElement.getTextContent();
                            System.out.println("Value string " + valueString);
                            boolean value = Boolean.valueOf(valueString);
                            // System.out.println(evalsElement.getTextContent() + "to jest wartosc faktu");
                            System.out.println(value + "to jest warosc faktu");
                            System.out.println("==============================================");
                            if (!factId.equals("")) {
                             
                                fact.setFactValueById(factId, value);
                            } 
                        }
                    }
                    if (!fact.getDescription().equals("")) {
                        this.factRepository.addFact(fact);
                    }
                    
                }
            }                
        }
    }    
}


    public FactRepository getFactRepository() {
        return this.factRepository;
    }
}