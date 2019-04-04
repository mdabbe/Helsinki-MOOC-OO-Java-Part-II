import java.util.*;

public class UI {
    private Map<String, Person> phoneBook;
    private Scanner scanner;

    public UI(Scanner scanner) {
        this.scanner = scanner;
        this.phoneBook = new HashMap<String, Person>();
    }

    public void start() {
        System.out.println("phone search\n" +
                                   "available operations:\n" +
                                   " 1 add a number\n" +
                                   " 2 search for a number\n" +
                                   " 3 search for a person by phone number\n" +
                                   " 4 add an address\n" +
                                   " 5 search for personal information\n" +
                                   " 6 delete personal information\n" +
                                   " 7 filtered listing\n" +
                                   " x quit\n");
        readCommand();
    }
    private void readCommand() {
        String input;
        while (true) {
            System.out.print("command: ");
            input = scanner.nextLine();
            if (input.equals("x")) { break; }
            int command = Integer.parseInt(input);
            switch (command) {
                case 1 :
                    addNumber();
                    System.out.println();
                    break;
                case 2 :
                    searchByName();
                    break;
                case 3 :
                    searchByNumber();
                    break;
                case 4 :
                    addAddress();
                    break;
                case 5 :
                    search();
                    break;
                case 6 :
                    delete();
                    break;
                case 7 :
                    filteredListing();
                    break;
            }
        }
    }

    private void filteredListing() {
        List<Person> sortedList = sortedList();
        System.out.print("keyword (if empty, all listed): ");
        String keyword = scanner.nextLine();
        System.out.println();
        boolean foundNothing = true;
        for (Person person : sortedList) {
            if (person.getName().contains(keyword) ||
                    person.getAddress().contains(keyword) ||
                    person.getNumbers().toString().contains(keyword)) {
                System.out.println(" " + person.getName());
                System.out.println("  address: " + person.getAddress());
                System.out.println("  phone numbers:");
                for (String number : person.getNumbers()) {
                    System.out.println("   " + number);
                }
                foundNothing = false;
            }
        }
        if (foundNothing) {
            System.out.println(" keyword not found");
        }

    }

    private void delete() {
        System.out.print("whose information: ");
        String name = scanner.nextLine();
        if (!phoneBook.containsKey(name)) {
            System.out.println("  not found");
        } else {
            phoneBook.remove(name);
        }
    }

    private void search() {
        System.out.print("whose information: ");
        String name = scanner.nextLine();
        if (phoneBook.containsKey(name)) {
            Person person = phoneBook.get(name);
            System.out.println("  address: " + person.getAddress());
            if (person.getNumbers().isEmpty()) {
                System.out.println("  phone number not found");
            } else {
                System.out.println("  phone numbers:");
                for (String phoneNumber : person.getNumbers()) {
                    System.out.println("   " + phoneNumber);
                }
            }
        } else {
            System.out.println("  not found");
        }

    }

    private void addAddress() {
        System.out.print("whose address: ");
        String name = scanner.nextLine();
        System.out.print("street: ");
        String street = scanner.nextLine();
        System.out.print("city: ");
        String city = scanner.nextLine();
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).setAddress(street + " " + city);
        } else {
            phoneBook.put(name, new Person(name));
            phoneBook.get(name).setAddress(street + " " + city);
        }
    }

    private void searchByNumber() {
        System.out.print("number: ");
        String num = scanner.nextLine();
        for (Person person : phoneBook.values()) {
            if (person.isNumber(num)) {
                System.out.println(" " + person.getName());
                return;
            }
        }
        System.out.println(" not found");

    }

    private void searchByName() {
        System.out.print("whose number: ");
        String name = scanner.nextLine();
        Person person = phoneBook.get(name);
        if (person == null) {
            System.out.println("  not found");
        } else {
            for (String number : person.getNumbers()) {
                System.out.println(" " + number);
            }
        }
    }

    private void addNumber() {
        System.out.print("whose number: ");
        String name = scanner.nextLine();
        System.out.print("number: ");
        String number = scanner.nextLine();
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new Person(name));
            phoneBook.get(name).addNum(number);
        } else {
            phoneBook.get(name).addNum(number);
        }
    }

    private List<Person> sortedList() {
        List<Person> people = new ArrayList<Person>(phoneBook.values());
        Collections.sort(people);
        return people;
    }

}
