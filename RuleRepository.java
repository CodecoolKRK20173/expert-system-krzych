import java.util.*;

public class RuleRepository {

    Map<String,Question> questionsMap;

    public RuleRepository() {
        this.questionsMap = new HashMap<String,Question>();
    }

    public void addQuestion(Question question) {
        this.questionsMap.put(question.getId(), question);
    }

    class QuestionIterator implements Iterator<Object> {

        
        public Object next() {
            return this.next();
        }
    
        public boolean hasNext() {
            return true;
        }
    }

}