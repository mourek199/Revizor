package commands;

import code.GameMap;
import code.Location;
import code.Revizor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WaitTest {

    Wait wait;
    Revizor revizor;
    GameMap gameMap;
    Location location;

    @Before
    public void setUp() throws Exception {
        location = new Location();
        location.setName("bla bla");
        revizor = new Revizor();
        gameMap = new GameMap();
        revizor.setHeadingLocation(location);
        wait = new Wait(revizor, gameMap);
        revizor.setRideTime(3);
        revizor.setTimeElapsed(3);
    }

    @Test
    public void shortRest() {
        assertEquals(4,wait.shortRest());
    }

    @Test
    public void isArrived() {
        assertEquals(true,wait.isArrived());
    }
}