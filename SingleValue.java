import java.util.*;

public class SingleValue extends Value {

    

    SingleValue(String parameter, boolean selectionType) {
        this.inputPattern = new ArrayList<String>();
        this.inputPattern.add(parameter);
        this.selectionType = selectionType;
    }
}