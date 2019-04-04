package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt
        try {
            WordInspection wordInspection = new WordInspection(file);
            System.out.println(wordInspection.wordCount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
