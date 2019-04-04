import java.util.Scanner;
public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start() {
        String input;
        System.out.println("Statements:\n" +
                "add - adds a word pair to the dictionary\n" +
                "translate - asks a word and prints its translation\n" +
                "quit - quit the text user interface\n");
        while (true) {
            input = reader.nextLine();
            if (input.toLowerCase().equals("quit")) {
                quit();
                break;
            } else if ("add".equals(input.toLowerCase())) {
                this.add();
            } else if ("translate".equals(input.toLowerCase())) {
                this.translate();
            } else {
                System.out.println("Unknown statement");
            }
            System.out.print("Statement: ");
        }
    }
    public void translate() {
        System.out.println("Give a word: ");
        String input = reader.nextLine();
        System.out.println("Translation: " + dictionary.translate(input));
        System.out.println();
    }
    public void add() {
        System.out.println("In Finnish: ");
        String inFinnish = reader.nextLine();
        System.out.println("Translation: ");
        String translation = reader.nextLine();
        dictionary.add(inFinnish,translation);
        System.out.println();
    }

    public void quit() {
        System.out.println("Cheers!");
    }
}
