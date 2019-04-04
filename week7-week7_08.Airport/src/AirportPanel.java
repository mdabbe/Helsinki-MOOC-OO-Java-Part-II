import java.util.HashMap;
import java.util.Scanner;

public class AirportPanel {
    private Scanner scanner;
    private HashMap<String, Plane> planes;
    private HashMap<Flight, Plane> flights;


    public AirportPanel(Scanner scanner, HashMap<String, Plane> planes, HashMap<Flight, Plane> flights) {
        this.scanner = scanner;
        this.planes = planes;
        this.flights = flights;
    }

    public void start(){
        System.out.println("Airport panel\n" +
                "--------------------\n");
        String input;
        while (true) {
            System.out.println("Choose operation:\n" +
                    "[1] Add airplane\n" +
                    "[2] Add flight\n" +
                    "[x] Exit\n");
            System.out.print(">");
            input=scanner.nextLine();
            if (input.equals("1")) {
                this.addAirplane();
            } else if (input.equals("2")) {
                this.addFlight();
            } else if (input.equals("x")) {
                break;
            }
        }
    }

    private void addAirplane(){
        System.out.println("Give plane ID: ");
        String id = scanner.nextLine();
        System.out.println("Give plane capacity: ");
        int capacity = scanner.nextInt();
        planes.put(id,new Plane(id,capacity));
    }
    private void addFlight(){
        System.out.println("Give plane ID: ");
        String planeId = scanner.nextLine();
        System.out.println("Give departure airport code: ");
        String depAirCode = scanner.nextLine();
        System.out.println("Give destination airport code: ");
        String destAirCode = scanner.nextLine();
        flights.put(new Flight(depAirCode,destAirCode), planes.get(planeId));

    }

}
