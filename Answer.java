import java.util.*;

public class Answer {
    
    private Map<String,Boolean> mapOfValue;

    public Answer() {
        this.mapOfValue = new HashMap<String,Boolean>();
    }

    public void addValue(Value value) {
        System.out.println("GEtinput pattern lengrht :" + value.getInputPattern().size());
        for (int i = 0; i < value.getInputPattern().size(); i++) {
            System.out.println("wlozyl to: ");
            System.out.println(value.getInputPattern().get(i));
            this.mapOfValue.put(value.getInputPattern().get(i), value.getSelectionType());
        }
    }


    public boolean evaluateAnswerByInput(String input) {
        return this.mapOfValue.get(input);
    }

    
    public String getSetOfAnswers() {
        StringBuilder sb = new StringBuilder();
        Set<String> setOfKeys = this.mapOfValue.keySet();

        for (String item : setOfKeys) {
            sb.append(item);
            sb.append("    ");
        }
        return sb.toString();
    }
}