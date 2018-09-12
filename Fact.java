import java.util.*;

public class Fact {

    private String description;
    private String factId;

    private Map<String,Boolean> mapOfValue;


    public Fact(String factId, String description) {
        this.description = description;
        this.factId = factId;
        this.mapOfValue = new HashMap<String,Boolean>();
    }

    
    public Set<String> getIdSet() {
        return this.mapOfValue.keySet();
    }

    public String getDescription() {
        return this.description;
    }

    public void setFactValueById(String id, boolean value) {
        this.mapOfValue.put(id, value);
    }

    public boolean getValueById(String id) {
        return this.mapOfValue.get(id);
    }


}