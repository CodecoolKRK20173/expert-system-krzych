import java.util.*;

public class RuleRepository {

    Map<String,Question> questionsMap;

    public RuleRepository() {
        this.questionsMap = new HashMap<String,Question>();
    }

    public void addQuestion(Question question) {
        this.questionsMap.put(question.getId(), question);
    }

    public Iterator getQuestionIterator() {
        return new QuestionIterator(this);
    }


    class QuestionIterator implements Iterator {

        private int currentIndex;
        private String[] arrayOfQuestion;
        private int sizeOfQuestionMap;

        public QuestionIterator(RuleRepository ruleRepo) {
            this.currentIndex = 0;
            Set<String> keysOfQuestionMap = ruleRepo.questionsMap.keySet();
            this.arrayOfQuestion = new String[keysOfQuestionMap.size()];
            this.arrayOfQuestion = keysOfQuestionMap.toArray(arrayOfQuestion);
            this.sizeOfQuestionMap = keysOfQuestionMap.size();
        }


        public Question next() {
            Question nextQuestion = questionsMap.get(arrayOfQuestion[currentIndex]); 
            currentIndex ++;
            return nextQuestion;
        }
    
        public boolean hasNext() {
            if (currentIndex < sizeOfQuestionMap) {
                return true;
            }
            return false;
        }
    }

}