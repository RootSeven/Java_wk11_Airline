import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PassengerTest {

    private Passenger passenger1;
    private Flight flight1;
    private Plane plane1;

    @Before
    public void before(){
        plane1 = new Plane( PlaneType.BOEING747 );
        passenger1 = new Passenger("Mr. Dry Hands", 2);
        flight1 = new Flight(plane1, "ED100", "Glasgow", "Edinburgh", "22:00");
    }

    @Test
    public void canGetName(){
        assertEquals("Mr. Dry Hands", passenger1.getName());
    }

    @Test
    public void canGetBagCount(){
        assertEquals(2, passenger1.getNumberOfBags());
    }

    @Test
    public void passengerStartsWithNoFlight(){
        assertEquals(null, passenger1.getFlight());
    }

    @Test
    public void passengerCanSaveTheirFlight(){
        flight1.bookPassenger(passenger1);
        assertEquals( flight1, passenger1.getFlight() );
    }

    @Test
    public void passengerStartsWithNoSeat(){
        assertEquals( 0, passenger1.getSeatNumber() );
    }

    @Test
    public void passengerCanGetRandomSeat(){
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        assertNotEquals( 0, passenger1.getSeatNumber() );
    }
}
