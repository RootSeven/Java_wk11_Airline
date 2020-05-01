import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger1;

    @Before
    public void before(){
        passenger1 = new Passenger("Mr. Dry Hands", 2);
    }

    @Test
    public void canGetName(){
        assertEquals("Mr. Dry Hands", passenger1.getName());
    }

    @Test
    public void canGetBagCount(){
        assertEquals(2, passenger1.getNumberOfBags());
    }

}
