package dictionary;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class MindfulDictionary {
    private Map<String, String> words;
    private Map<String, String> reverseWords;
    private String file;

    public MindfulDictionary() {
        this.words = new HashMap<String, String>();
        this.reverseWords = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this.words = new HashMap<String, String>();
        this.reverseWords = new HashMap<String, String>();
        this.file = file;
    }

    public boolean load() {
        try {
            Scanner filereader = new Scanner(new File(this.file));
            while (filereader.hasNextLine()) {
                String line = filereader.nextLine();
                String[] wordPair = line.split(":");
                words.put(wordPair[0],wordPair[1]);
                reverseWords.put(wordPair[1],wordPair[0]);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public void add(String word, String translation){
        if (!(words.containsKey(word) || reverseWords.containsKey(translation))) {
            this.words.put(word,translation);
            this.reverseWords.put(translation,word);
        }
    }

    public String translate(String word) {
        if (words.containsKey(word)) {
            return words.get(word);
        } else return reverseWords.getOrDefault(word, null);
    }

    public boolean save() {
        try {
            List<String> data = new ArrayList<String>();
            for (String word : words.keySet()) {
                data.add(word + ":" + words.get(word) + "\n");
            }
            FileWriter fileWriter = new FileWriter(new File(this.file));
            StringBuilder lines = new StringBuilder();
            for (String s : data) { lines.append(s);}
            fileWriter.write(lines.toString());
            fileWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void remove(String word) {
        if (words.containsKey(word)) {
            reverseWords.remove(words.get(word));
            words.remove(word);
        } else if (reverseWords.containsKey(word)) {
            words.remove(reverseWords.get(word));
            reverseWords.remove(word);
        }
    }
}
