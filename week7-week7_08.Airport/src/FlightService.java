import java.util.HashMap;
import java.util.Scanner;

public class FlightService {
    private Scanner scanner;
    private HashMap<String, Plane> planes;
    private HashMap<Flight, Plane> flights;

    public FlightService(Scanner scanner, HashMap<String, Plane> planes, HashMap<Flight, Plane> flights) {
        this.scanner = scanner;
        this.planes = planes;
        this.flights = flights;
    }

    public void start() {
        System.out.println("Flight service\n" +
                "------------\n");
        String input;
        while (true) {
            System.out.println("Choose operation:\n" +
                    "[1] Print planes\n" +
                    "[2] Print flights\n" +
                    "[3] Print plane info\n" +
                    "[x] Quit\n");
            input = scanner.nextLine();
            if (input.equals("x")) {
                break;
            } else if (input.equals("1")) {
                this.printPlanes();
            } else if (input.equals("2")) {
                this.printFlights();
            } else if (input.equals("3")) {
                this.printPlaneInfo();
            }

        }
    }

    private void printPlanes() {
        for (String s : planes.keySet()) {
            System.out.println(planes.get(s));
        }
    }
    private void printFlights() {
        for (Flight flight : flights.keySet()) {
            System.out.println(flights.get(flight) + " " + flight);
        }
    }

    private void printPlaneInfo() {
        System.out.println("Give plane ID: ");
        String planeId = scanner.nextLine();
        System.out.println(planes.get(planeId));
    }
}
