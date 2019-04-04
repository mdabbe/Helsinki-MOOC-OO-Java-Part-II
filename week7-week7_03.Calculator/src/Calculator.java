public class Calculator {
    private Reader reader;
    private int statistics = 0;

    public Calculator() {
        this.reader = new Reader();
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }

        statistics();
    }
    private void sum() {
        int[] values = read();
        int sum = values[0] + values[1];
        System.out.println("sum of the values " + sum);
        statistics++;

    }
    private void difference() {
        int[] values = read();
        int difference = values[0] - values[1];
        System.out.println("difference of the values " + difference);
        statistics++;
    }
    private void product() {
        int[] values = read();
        int product = values[0] * values[1];
        System.out.println("product of the values " + product);
        statistics++;
    }
    private void statistics() {
        System.out.println("Calculations done " + statistics);
    }



    private int[] read() {
        int[] values = new int[2];
        System.out.print("value1: ");
        values[0] = reader.readInteger();
        System.out.print("value2: ");
        values[1] = reader.readInteger();
        return values;
    }

}
