public class Flight {
    private String departureAirportCode;
    private String destinationAirportCode;

    public Flight(String departureAirportCode, String destinationAirportCode) {
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    @Override
    public String toString() {
        return "(" + this.departureAirportCode + "-" + this.destinationAirportCode + ")";
    }
}
