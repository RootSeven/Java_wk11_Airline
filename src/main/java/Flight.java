import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> bookedPassengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, String departureTime) {
        this.bookedPassengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
    }

    public ArrayList<Passenger> getBookedPassengers() {
        return bookedPassengers;
    }

    public Plane getPlane() {
        return plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int availableSeatCount() {
        int maximumCapacity = getPlane().getPlaneType().getCapacity();
        int bookedSeats = this.bookedPassengers.size();
        return maximumCapacity - bookedSeats;
    }

    public void bookPassenger(Passenger passenger) {
        if (this.availableSeatCount() > 0) {
            this.bookedPassengers.add(passenger);
        }
    }
}
