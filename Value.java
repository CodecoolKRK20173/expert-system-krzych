import java.util.*;

public abstract class Value {
    
    protected List<String> inputPattern;
    protected boolean selectionType;

    public List<String> getInputPattern() {
        return this.inputPattern;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
}