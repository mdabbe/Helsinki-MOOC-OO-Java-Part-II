package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordInspection {
    private File file;
    private Scanner reader;
    private List<String> words = new ArrayList<String>();

    public WordInspection(File file) throws Exception {
        this.file = file;
        this.reader = new Scanner(file,"UTF-8");
        while (reader.hasNextLine()) {
            words.add(reader.nextLine());
        }
    }

    public int wordCount(){
        int row = 0;
        for (String s : words) {
            row++;
        }
        return row;
    }

    public List<String> wordsContainingZ() {
        List<String> wordContainingZ = new ArrayList<String>();
        for (String word : words) {
            if (word.contains("z")) {
                wordContainingZ.add(word);
            }
        }
        return wordContainingZ;
    }

    public List<String> wordsEndingInL() {
        List<String> wordsEndingInL = new ArrayList<String>();
        for (String word : words) {
            if (word.endsWith("l")) {
                wordsEndingInL.add(word);
            }
        }
        return wordsEndingInL;
    }

    public List<String> wordsWhichContainAllVowels() {
        List<String> wordsWhichContainAllVowel = new ArrayList<String>();
        for (String word : words) {
            if (word.contains("ä") && word.contains("ö")
                    && word.contains("y") && word.contains("u") && word.contains("o")
                    && word.contains("i") && word.contains("e") && word.contains("a")) {
                wordsWhichContainAllVowel.add(word);
            }
        }
        return wordsWhichContainAllVowel;
    }

    public List<String> palindromes() {
        List<String> palindromes = new ArrayList<String>();
        for(String word : words) {
            boolean isPalindrome = true;
            for (int i = 0; i < word.length(); i++) {
                    if (word.charAt(i) != word.charAt((word.length()-1) - i)) {
                        isPalindrome = false;
                    }
            }
            if (isPalindrome) {
                palindromes.add(word);
            }
        }
        return palindromes;
    }
}
