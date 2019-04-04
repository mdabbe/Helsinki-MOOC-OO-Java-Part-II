package file;

import java.io.File;
import java.util.Scanner;

public class Analysis {
    private File file;
    private Scanner reader;
    public Analysis(File file) {
        this.file = file;
    }

    public int lines() throws Exception {
        this.reader = new Scanner(file);
        int count = 0;
        String s;
        while (reader.hasNext()) {
            s = reader.nextLine();
            count++;
        }
        return count;
    }

    public int characters() throws Exception {
        reader = new Scanner(file);
        int chars = 0;
        String s;
        while (reader.hasNext()) {
            s = reader.nextLine();
            chars += s.length();
        }
        return chars + lines();
    }
}
