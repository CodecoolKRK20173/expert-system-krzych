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
        System.out.println(evaluate() + "wynik"); 
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

    public String evaluate() {

        Iterator<Fact> fIterator = this.fParser.getFactRepository().getIterator();
        
        
        while(fIterator.hasNext()) {

            boolean compareFlag = true;
            Fact currentFact = fIterator.next();
            System.out.println(currentFact.getDescription() + "tu ma byc");

           
                Set<String> keySet = currentFact.getIdSet();
                int countOfRecordsInFact = keySet.size();
                int countOfAnswerMatchToFact = 0;
                String[] keyArray = new String[countOfRecordsInFact];
                keyArray = keySet.toArray(keyArray);
                for (String item : keyArray) {
                    System.out.println("ziterowal fakt");
                    System.out.println(currentFact.getValueById(item) + " dla faktu: " + currentFact.getDescription());
                    System.out.println(userAnswersMap.get(item) + " odpowiedz usera");
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

    // evaluate do zrobienia!
}
