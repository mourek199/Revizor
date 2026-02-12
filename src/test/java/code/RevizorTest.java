package code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RevizorTest {

    Revizor revizor1;
    Revizor revizor2;

    @Before
    public void setUp() throws Exception {
        revizor1 = new Revizor();
        revizor1.setRideTime(5);

        revizor2 = new Revizor();
        revizor2.setRideTime(0);
    }

    @Test
    public void isTravelling() {
        assertEquals(true,revizor1.isTravelling());
        assertEquals(false,revizor2.isTravelling());
    }
}