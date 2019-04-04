import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> words;
    
    
    public Dictionary() {
        this.words = new HashMap<String, String>();
    }

    public void add(String word, String translation){
        this.words.put(word,translation);
    }
    public String translate(String word) {
        return this.words.get(word);
    }
    public int amountOfWords(){
        return this.words.size();
    }
    public ArrayList<String> translationList(){
        ArrayList<String> wordsList = new ArrayList<String>();
        for (String key : this.words.keySet()) {
            String word = key + " = " + this.words.get(key);
            wordsList.add(word);
        }
        return wordsList;
    }
}
