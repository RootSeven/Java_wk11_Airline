import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Flight {

    private Random rand = new Random();

    private ArrayList<Passenger> bookedPassengers;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private String departureTime;
    private ArrayList<Integer> availableSeats;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, String departureTime) {
        this.bookedPassengers = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.availableSeats = new ArrayList<Integer>();

        populateAvailableSeats();
    }

    public void populateAvailableSeats() {
        for ( int i = 0; i < this.plane.getPlaneType().getCapacity(); i++){
            this.availableSeats.add(i + 1);
        }
    }

    public ArrayList<Integer> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(ArrayList<Integer> availableSeats) {
        this.availableSeats = availableSeats;
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
            passenger.setFlight(this);

            int availableSeatIndex = rand.nextInt(this.availableSeats.size());
            passenger.setSeatNumber(this.availableSeats.get(availableSeatIndex));
            this.availableSeats.remove(availableSeatIndex);
        }
    }
}
