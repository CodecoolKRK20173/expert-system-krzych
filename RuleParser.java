import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;


public class RuleParser extends XMLParser {
    
    private RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        Document ruleDoc = this.loadXMLDocument("rules.xml");
        parse1(ruleDoc);
        
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

    private void parse1(Document ruleDoc) {
        Element root = ruleDoc.getDocumentElement();
        NodeList firstParentsList = root.getChildNodes();

        for (int i = 0; i < firstParentsList.getLength(); i++) {

            Node nodeFromLevelOne = firstParentsList.item(i);

            if (nodeFromLevelOne instanceof Element) {
                Element firstBranch = (Element) nodeFromLevelOne;
                String id = firstBranch.getAttribute("id");
                System.out.println(id);

                NodeList secondParentsList = firstBranch.getChildNodes();

                for (int j = 0; j < secondParentsList.getLength(); j++) {

                    Node nodeFromLevelTwo = secondParentsList.item(j);

                    if (nodeFromLevelTwo instanceof Element) {

                        Element secondBranch = (Element) nodeFromLevelTwo;

                        
                            
                            String question = secondBranch.getTextContent();
                            System.out.println(question);
                        
                        

                            NodeList thirdParentsList = secondBranch.getChildNodes();

                            for (int k = 0; k < thirdParentsList.getLength(); k++) {

                                Node nodeFromLevalThree = thirdParentsList.item(k);

                                if (nodeFromLevalThree instanceof Element) {
                                    
                                    Element thirdBranch = (Element) nodeFromLevalThree;
                                    boolean value = Boolean.parseBoolean(thirdBranch.getAttribute("value"));
                                    System.out.println(value);

                                    // String[] arrayOfAnswersOption = thirdBranch.getFirstChild().getNodeValue().split(",");
                                    // System.out.println(arrayOfAnswersOption[0]);

                                    NodeList fourthParentsList = thirdBranch.getChildNodes();

                                    for (int l = 0; l < fourthParentsList.getLength(); l++) {

                                        Node nodeFromLevelFour = fourthParentsList.item(l);

                                        if (nodeFromLevelFour instanceof Element) {

                                            Element fourthBranch = (Element) nodeFromLevelFour;
                                            String[] arrayOfanswsersPatterns = fourthBranch.getAttribute("value").split(",");
                                            System.out.println(arrayOfanswsersPatterns[0]);
                                        }

                                    }

                                }
                            }

                        
                    }
                }
            }

            



            
        }
    } 
}