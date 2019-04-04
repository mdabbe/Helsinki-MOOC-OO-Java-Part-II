import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Printer {
    private File file;
    private Scanner reader;
    private ArrayList<String> words;

    public Printer(String fileName) throws Exception {
        this.file = new File(fileName);
        reader = new Scanner(file);
        words = new ArrayList<String>();
        while (reader.hasNext()) {
            words.add(reader.nextLine());
        }
    }


    public void printLinesWhichContain(String word) {
        for (String line : words) {
            if (word.isEmpty()) {
                System.out.println(line);
            } else if (line.contains(word)) {
                System.out.println(line);
            }
        }
    }


}
