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
        Document FactDoc = this.loadXMLDocument("rules.xml");
        Element element = FactDoc.getDocumentElement();
    }

    public RuleRepository getRuleRepository() {
        return this.ruleRepository;
    }
}