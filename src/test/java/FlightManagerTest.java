import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager;
    private Flight flight1;
    private Plane plane1;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("Raul", 1);
        passenger2 = new Passenger( "Mairi", 1);
        passenger3 = new Passenger("Josh", 1);

        plane1 = new Plane( PlaneType.BOEING747 );
        flight1 = new Flight(plane1, "ED100", "Glasgow", "Edinburgh", "22:00");
        flightManager = new FlightManager();

        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger2);
        flight1.bookPassenger(passenger3);
    }

    @Test
    public void canCalculateBaggagePerPassenger(){
        assertEquals( 2, flightManager.baggagePerPassenger(flight1) );
    }

    @Test
    public void canCalculateTotalBaggageWeight(){
        assertEquals( 3, flightManager.totalBaggageWeight(flight1) );
    }

    @Test
    public void canGetRemainingBaggageWeight(){
        assertEquals( 0, flightManager.remainingBaggageWeight(flight1) );
    }

    @Test
    public void canBubbleSortPassengerSeats(){
        flightManager.bubbleSortPassengerSeats(flight1);

        assertEquals( 1, flight1.getBookedPassengers().get(0).getSeatNumber() );
        assertEquals( 2, flight1.getBookedPassengers().get(1).getSeatNumber() );
        assertEquals( 3, flight1.getBookedPassengers().get(2).getSeatNumber() );
    }

}
