package code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    Location location;

    @Before
    public void setUp() throws Exception {
        location = new Location();
        location.setPassengersDone(5);
        location.setInnitPassengerSize(10);
    }

    @Test
    public void getCompletion() {
        assertEquals(50,location.getCompletion(),0);
    }
}