import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane1;

    @Before
    public void before() {
        plane1 = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void canGetPlaneType(){
        assertEquals( PlaneType.BOEING747, plane1.getPlaneType() );
    }

}
