import org.w3c.dom.Element;

import java.util.Iterator;

import org.w3c.dom.*;


public class ESProvider {

    private FactParser fParser; 
    private RuleParser rParser;
    

    public ESProvider(FactParser fParser, RuleParser rParser) {
        this.fParser = fParser;
        this.rParser = rParser;
        Iterator iter = this.rParser.getRuleRepository().getQuestionIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}



    //     Document FactDoc = fParser.loadXMLDocument("facts.xml");
    //     Element element = FactDoc.getDocumentElement();

       
    //     NodeList nodes = element.getChildNodes();
    //     // System.out.println(nodes.getLength() + " dlugosc pierwszej");
        
        
    //     for (int i = 0; i < nodes.getLength(); i++) {
            
    //         Node node = nodes.item(i);

    //         if (node instanceof Element) {

    //             // System.out.println("Zrobil");
    //             Element child = (Element) node;
    //             System.out.println(child.getAttribute("id"));
    //             // System.out.println(child.getAttribute("value"));
    //             // System.out.println(child.getElementsByTagName("Description").item(0));
    //             // System.out.println(child.getElementsByTagName("Eval").item(1).getTextContent());
                
                
    //             NodeList childList = child.getChildNodes();
    //             // System.out.println(childList.getLength() + " dljgosc drugiej");

    //             for (int j = 0; j < childList.getLength(); j++) {
    //                 Node childNode = childList.item(j);

    //                 if (childNode instanceof Element) {
    //                     Element childElement = (Element) childNode;
    //                     System.out.println(childElement.getAttribute("value"));
                        
                    

    //                 NodeList evalsList = childElement.getChildNodes();
    //                 // System.out.println("evals list lenght: " + evalsList.getLength());
                    

    //                     for (int k = 0; k < evalsList.getLength(); k++) {

    //                         Node evalsNode = evalsList.item(k);

    //                         if (evalsNode instanceof Element) {
    //                             Element evalsElement = (Element) evalsNode;
    //                             System.out.println(evalsElement.getAttribute("id"));
    //                             System.out.println(evalsElement.getTextContent());
    //                         }
    //                     }
    //                 }
    //             }                
    //         }
    //     }    
    // }  /// przeniesc ten absurd do konstruktora FactParsera
    
    // private List<String> getChildElementAndIterateByAttributes(Element nodelist, String atrrName) {
    //     NodeList nodes = nodelist.getChildNodes();
    //     for (int i = 0; i < nodes.getLength(); i++) {
            
    //         Node node = nodes.item(i);

    //         if (node instanceof Element) {

    //             System.out.println("Zrobil");
    //             Element child = (Element) node;
    //             System.out.println(child.getAttribute(atrrName));
    //         }
    //     }
    //     return child; 
    // }
// }