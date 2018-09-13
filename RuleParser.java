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
        parse1(ruleDoc);
        
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }

    private void parse1(Document ruleDoc) {
        Element root = ruleDoc.getDocumentElement();
        NodeList firstParentsList = root.getChildNodes();
        System.out.println("Pierwsz lista dlu " + firstParentsList.getLength());

        String question = "";
        Question newQuestion = null;

        for (int i = 0; i < firstParentsList.getLength(); i++) {
            System.out.println("Iteracja i nr: " + i);
            System.out.println(firstParentsList.item(i));
            
            Node nodeFromLevelOne = firstParentsList.item(i);

            if (nodeFromLevelOne instanceof Element) {
                Element firstBranch = (Element) nodeFromLevelOne;
                String id = firstBranch.getAttribute("id");
                System.out.println(id);

                NodeList secondParentsList = firstBranch.getChildNodes();

                System.out.println("Druga lista size" + secondParentsList.getLength());
                for (int j = 0; j < secondParentsList.getLength(); j++) {
                    System.out.println("Iteracja j nr: " + j);
                    System.out.println("Nazwa itemu " + secondParentsList.item(j));
                    Node nodeFromLevelTwo = secondParentsList.item(j);

                    if (nodeFromLevelTwo instanceof Element) {

                        Element secondBranch = (Element) nodeFromLevelTwo;

                        
                            if (secondBranch.getNodeName().equals("Question")) {
                                question = secondBranch.getTextContent();
                                System.out.println("toooo " + question);
                                newQuestion = new Question(id, question, new Answer());
                                this.ruleRepository.addQuestion(newQuestion);
                            }
                        

                            NodeList thirdParentsList = secondBranch.getChildNodes();
                            System.out.println("trzecia lista size  " + thirdParentsList.getLength());
                            for (int k = 0; k < thirdParentsList.getLength(); k++) {
                                System.out.println("Iteracja k nr: " + k);
                                System.out.println("Nazwa itemu " + thirdParentsList.item(k));
                                Node nodeFromLevalThree = thirdParentsList.item(k);

                                if (nodeFromLevalThree instanceof Element) {
                                    
                                    Element thirdBranch = (Element) nodeFromLevalThree;
                                    boolean value = Boolean.parseBoolean(thirdBranch.getAttribute("value"));
                                    System.out.println(value);

                                    // String[] arrayOfAnswersOption = thirdBranch.getFirstChild().getNodeValue().split(",");
                                    // System.out.println(arrayOfAnswersOption[0]);

                                    NodeList fourthParentsList = thirdBranch.getChildNodes();
                                    System.out.println("czawrta lista size " + fourthParentsList.getLength());
                                    for (int l = 0; l < fourthParentsList.getLength(); l++) {
                                        System.out.println("Iteracja l nr: " + l);
                                        System.out.println("Nazwa itemu " + fourthParentsList.item(l));
                                        Node nodeFromLevelFour = fourthParentsList.item(l);

                                        if (nodeFromLevelFour instanceof Element) {

                                            Element fourthBranch = (Element) nodeFromLevelFour;
                                            String[] arrayOfanswsersPatterns = fourthBranch.getAttribute("value").split(",");
                                            System.out.println(arrayOfanswsersPatterns[0]);

                                            if (!question.equals("")) {
                                                

                                                List<String> parameterList = convertArrayToList(arrayOfanswsersPatterns);
                                                System.out.println("Lenght of parameter list " + parameterList.size());
                                                System.out.println(question + "czy jest puste");
                                                System.out.println("ID :" + id);
                                                System.out.println("Value: " + value);
                                                System.out.println("Parameter list 1 " + parameterList.get(0));

                                                if (parameterList.size() == 1) {
                                                    System.out.println("weszlo do pojedynczego");
                                                    
                                                    newQuestion.getAnswer().addValue(new SingleValue(parameterList.get(0), value));
                                                    
                                                }
                                                else if (parameterList.size() > 1) {
                                                    System.out.println("weszlo do multi");
                                                    
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