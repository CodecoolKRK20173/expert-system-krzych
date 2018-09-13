import org.w3c.dom.Element;

import java.util.*;

import org.w3c.dom.*;


public class ESProvider {

    private FactParser fParser; 
    private RuleParser rParser;
    private Map<String,Boolean> userAnswersMap;
    

    public ESProvider(FactParser fParser, RuleParser rParser) {
        this.fParser = fParser;
        this.rParser = rParser;
        this.userAnswersMap = new HashMap<String,Boolean>();
        collectAnswers();
    }



    public void collectAnswers() {
        UI viewer = new UI();
        Iterator<Question> iter = this.rParser.getRuleRepository().getQuestionIterator();

        while (iter.hasNext()) {
            Question currentQuestion = iter.next();
            boolean correctInputFlag = false;
            String userAnswer = "";
           
            while(!correctInputFlag) {

                viewer.printSeparateLine();
                viewer.printMessage(currentQuestion.getQuestion());
                viewer.printSeparateLine();
                viewer.printMessage("Answers options: ");
                viewer.printMessage(currentQuestion.getAnswer().getSetOfAnswers());
                viewer.printThickSeparateline();
                viewer.printMessage("Enter Your answer below: (if You will choose more than one option You have to separate answers by comma) ");
                userAnswer = viewer.getStringInputFromUser();
                
                    try {
                        this.userAnswersMap.put(currentQuestion.getId(), currentQuestion.getEvaluatedAnswer(userAnswer));
                        correctInputFlag = true;
                        } catch (NullPointerException err) {
                            viewer.printMessage("No such answer!");
                        } 
            }
            
        }
    } 
}
