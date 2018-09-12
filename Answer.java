import java.util.*;

public class Answer {
    
    Map<String,Boolean> mapOfValue;

    public Answer() {
        this.mapOfValue = new HashMap<String,Boolean>();
    }

    public void addValue(Value value) {
        for (int i = 0; i < value.getInputPattern().size(); i++) {
            this.mapOfValue.put(value.getInputPattern().get(i), value.getSelectionType());
        }
    }


    public boolean evaluateAnswerByInput(String input) {
        return this.mapOfValue.get(input);
    }
}