public class Calculator {
    private int number;

    public Calculator() {
        number = 0;
    }

    public int getNumber() {
        return number;
    }

    public void add(int number) {
        this.number += number;
    }

    public void take(int number) {
        this.number -= number;
    }

    public void clear() {
        number = 0;
    }
}
