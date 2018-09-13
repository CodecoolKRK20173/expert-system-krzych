import org.w3c.dom.Element;

import java.util.Iterator;

import org.w3c.dom.*;


public class ESProvider {

    private FactParser fParser; 
    private RuleParser rParser;
    

    public ESProvider(FactParser fParser, RuleParser rParser) {
        this.fParser = fParser;
        this.rParser = rParser;
        collectAnswers();
    }

    public void collectAnswers() {
        UI viewer = new UI();
        Iterator<Question> iter = this.rParser.getRuleRepository().getQuestionIterator();
        while (iter.hasNext()) {
            Question currentQuestion = iter.next();
            viewer.printSeparateLine();
            viewer.printMessage(currentQuestion.getQuestion());
            viewer.printSeparateLine();
            viewer.printMessage("Answers options: ");
            viewer.printMessage(currentQuestion.getAnswer().getSetOfAnswers());
            viewer.printMessage("Enter Your answer (if You will choose more than one option You have to separate answers by comma): ");
            String answer = viewer.getStringInputFromUser();
        }
        

    }   
}
