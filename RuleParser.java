import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.*;


public class RuleParser extends XMLParser {
    
    private RuleRepository ruleRepository;

    public RuleParser() {
        this.ruleRepository = new RuleRepository();
        Document ruleDoc = this.loadXMLDocument("rules.xml");
        parsingData(ruleDoc);
        
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

    private void parsingData(Document ruleDoc) {
        Element root = ruleDoc.getDocumentElement();
        NodeList firstParentsList = root.getChildNodes();
        
        String question = "";
        Question newQuestion = null;

        for (int i = 0; i < firstParentsList.getLength(); i++) {
            
            Node nodeFromLevelOne = firstParentsList.item(i);

            if (nodeFromLevelOne instanceof Element) {
                Element firstBranch = (Element) nodeFromLevelOne;
                String id = firstBranch.getAttribute("id");
                
                NodeList secondParentsList = firstBranch.getChildNodes();

                for (int j = 0; j < secondParentsList.getLength(); j++) {
                   
                    Node nodeFromLevelTwo = secondParentsList.item(j);

                    if (nodeFromLevelTwo instanceof Element) {

                        Element secondBranch = (Element) nodeFromLevelTwo;

                            if (secondBranch.getNodeName().equals("Question")) {
                                question = secondBranch.getTextContent();
                                newQuestion = new Question(id, question, new Answer());
                                this.ruleRepository.addQuestion(newQuestion);
                            }
                            NodeList thirdParentsList = secondBranch.getChildNodes();
                        
                            for (int k = 0; k < thirdParentsList.getLength(); k++) {
                                
                                Node nodeFromLevalThree = thirdParentsList.item(k);

                                if (nodeFromLevalThree instanceof Element) {
                                    
                                    Element thirdBranch = (Element) nodeFromLevalThree;
                                    boolean value = Boolean.parseBoolean(thirdBranch.getAttribute("value"));
                                
                                    NodeList fourthParentsList = thirdBranch.getChildNodes();
                                    
                                    for (int l = 0; l < fourthParentsList.getLength(); l++) {
                                        
                                        Node nodeFromLevelFour = fourthParentsList.item(l);

                                        if (nodeFromLevelFour instanceof Element) {

                                            Element fourthBranch = (Element) nodeFromLevelFour;
                                            String[] arrayOfanswsersPatterns = fourthBranch.getAttribute("value").split(",");
                                            
                                            if (!question.equals("")) {
                                                
                                                List<String> parameterList = convertArrayToList(arrayOfanswsersPatterns);
                                               
                                                if (parameterList.size() == 1) {
                                                    
                                                    newQuestion.getAnswer().addValue(new SingleValue(parameterList.get(0), value));
                                                    
                                                }
                                                else if (parameterList.size() > 1) {
                                                    
                                                    newQuestion.getAnswer().addValue(new MultiplyValue(parameterList, value));  
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
    }
    
    
    private List<String> convertArrayToList(String[] array) {
        List<String> summaryList = new ArrayList<String>();
        for (String item : array) {
            summaryList.add(item);
        }
        return summaryList;
    }
}