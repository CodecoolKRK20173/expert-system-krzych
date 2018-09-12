import java.util.*;

public class FactRepository {

    private Map<String,Fact> factsMap;

    public FactRepository() {
        this.factsMap= new HashMap<String,Fact>();
    }

    public void addFact(Fact fact) {
        this.factsMap.put(fact.getDescription(), fact);
    }

    public Iterator<Fact> getIterator() {
        return new FactIterator(this);
    }

    
    private class FactIterator implements Iterator {
        
        private int currentIndex;
        private int sizeOfFactsMap;
        private String[] arrayOfKeys;

        public FactIterator(FactRepository fRepository) {
            this.currentIndex = 0;
            Set<String> set = fRepository.factsMap.keySet();
            this.arrayOfKeys = new String[set.size()];
            this.arrayOfKeys = set.toArray(arrayOfKeys);
            this.sizeOfFactsMap = this.arrayOfKeys.length;   // tu byl null pointer jesli wczesniej tablica nie inicjalizowana

        }

        public Fact next() {
            Fact nextFact = factsMap.get(arrayOfKeys[currentIndex]);
            currentIndex ++;
            return nextFact;
        }
    
        public boolean hasNext() {
            if (this.currentIndex < this.sizeOfFactsMap) {
                return true;
            }
            return false;   
        }
    }
}


