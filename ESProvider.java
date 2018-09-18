import org.w3c.dom.Element;

import java.util.*;

import org.w3c.dom.*;


public class ESProvider {

    private FactParser fParser; 
    private RuleParser rParser;
    private Map<String,Boolean> userAnswersMap;
    private UI viewer;
    

    public ESProvider(FactParser fParser, RuleParser rParser) {
        this.fParser = fParser;
        this.rParser = rParser;
        this.viewer = new UI();
        this.userAnswersMap = new HashMap<String,Boolean>();
        viewer.cleanScreen();
        collectAnswers();
        viewer.cleanScreen();
        viewer.printResultsOfProgram(evaluate());
    }



    public void collectAnswers() {
        
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
                viewer.cleanScreen();
                
                    try {
                        this.userAnswersMap.put(currentQuestion.getId(), currentQuestion.getEvaluatedAnswer(userAnswer));
                        correctInputFlag = true;
                        } catch (NullPointerException err) {
                            viewer.printMessage("No such answer!");
                        } 
            }   
        }
    } 



    public String evaluate() {

        Iterator<Fact> fIterator = this.fParser.getFactRepository().getIterator();
        
        while(fIterator.hasNext()) {

            
            Fact currentFact = fIterator.next();
            Set<String> keySet = currentFact.getIdSet();
            int countOfRecordsInFact = keySet.size();
            int countOfAnswerMatchToFact = 0;
            String[] keyArray = new String[countOfRecordsInFact];
            keyArray = keySet.toArray(keyArray);
            for (String item : keyArray) {
                if (currentFact.getValueById(item) == this.userAnswersMap.get(item)) {
                    countOfAnswerMatchToFact ++;
                }
            }
            if (countOfAnswerMatchToFact == countOfRecordsInFact) {
                return currentFact.getDescription();
            }
        }
        return "Cannot solve problem";
    }

}
