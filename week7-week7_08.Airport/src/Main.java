import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Plane> planes = new HashMap<String, Plane>();
        HashMap<Flight, Plane> flights = new HashMap<Flight, Plane>();

        AirportPanel airportPanel = new AirportPanel(scanner, planes, flights);
        airportPanel.start();
        FlightService flightService = new FlightService(scanner, planes, flights);
        flightService.start();





    }
}
