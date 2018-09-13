import java.util.*;

public class MultiplyValue extends Value {
    
    

    public MultiplyValue(List<String> listOfParameters, boolean selectionType) {
        this.inputPattern = new ArrayList<String>();
        this.inputPattern = listOfParameters;

        this.selectionType = selectionType;
    }
}