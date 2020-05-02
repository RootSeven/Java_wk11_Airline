import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Flight flight1;
    private Passenger passenger1;
    private Plane plane1;
    private SimpleDateFormat parser;

    @Before
    public void before(){
        plane1 = new Plane(PlaneType.BOEING747);
        flight1 = new Flight(plane1, "ED100", "Glasgow", "Edinburgh", "22:00");
        passenger1 = new Passenger("Mairi", 1);
        parser = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
    }

    @Test
    public void canGetPlane(){
        assertEquals( plane1, flight1.getPlane() );
    }

    @Test
    public void bookedPassengersStartsEmpty(){
        assertEquals( 0, flight1.getBookedPassengers().size() );
    }

    @Test
    public void canGetFlightNumber(){
        assertEquals( "ED100", flight1.getFlightNumber() );
    }

    @Test
    public void canGetDestination(){
        assertEquals( "Glasgow", flight1.getDestination() );
    }

    @Test
    public void canGetDepartureAirport(){
        assertEquals( "Edinburgh", flight1.getDepartureAirport() );
    }

    @Test
    public void canGetDepartureTime(){
        assertEquals("22:00", flight1.getDepartureTime());
    }

    @Test
    public void canReturnNumberOfSeatsAvailable(){
        assertEquals( 3, flight1.availableSeatCount() );
    }

    @Test
    public void canBookAPassenger(){
        flight1.bookPassenger(passenger1);
        assertEquals( 2, flight1.availableSeatCount() );
    }

    @Test
    public void cannotOverbookFlight(){
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);
        flight1.bookPassenger(passenger1);

        assertEquals( 0, flight1.availableSeatCount() );
    }

}
