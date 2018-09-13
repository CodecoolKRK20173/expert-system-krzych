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
                if (checkIfInputIsCorrect(userAnswer, currentQuestion)) {
                    correctInputFlag = true;
                }
                else viewer.printMessage("No such answer!");
            }
            addRecordToUserAnswerMap(currentQuestion, userAnswer);
        }
    } 

    
    private boolean checkIfInputIsCorrect(String input, Question currentQuestion) {
        String[] arrayOfInput = input.split(",");
        for (String item : arrayOfInput) {
            if (currentQuestion.getAnswer().getSetOfAnswers().contains(item)) {
                return true;
            }
        }
        return false;   
    }  


    private void addRecordToUserAnswerMap(Question question, String userAnswer) {
        String[] userAnswerArray = userAnswer.split(",");
        if (userAnswerArray.length == 1) {
            this.userAnswersMap.put(question.getId(), question.getAnswer().evaluateAnswerByInput(userAnswerArray[0]));
        }
        else {
            int falseCount = 0;
            int trueCount = 0;
            for (String item : userAnswerArray) {
                if (question.getAnswer().evaluateAnswerByInput(item.toLowerCase())) {
                    trueCount ++;
                }
                else {
                    falseCount ++;
                }
            }
        if (trueCount > falseCount ) {
            this.userAnswersMap.put(question.getId(), true);
        }
        else this.userAnswersMap.put(question.getId(), false);
        }
    }
}
