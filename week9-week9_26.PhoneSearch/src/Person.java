import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable<Person> {
    private String name;
    private Set<String> numbers;
    private String address;

    public Person(String name) {
        this.name = name;
        this.numbers = new HashSet<String>();
        this.address = "address unknown";
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Set<String> getNumbers() {
        return numbers;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addNum(String number) {
        this.numbers.add(number);
    }

    public boolean isNumber(String num) {
        return this.numbers.contains(num);
    }

    public int compareTo(Person compared) {
        return this.name.compareToIgnoreCase(compared.getName());
    }
}
