package code.commands;


import code.Location;
import code.Revizor;
import commands.Suicide;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuicideTest {

    Revizor revizor;
    Location location;
    Suicide suicide;

    @Before
    public void setUp() throws Exception {

        revizor = new Revizor();
        suicide = new Suicide(revizor);
        revizor.setDepression(100);
        location = new Location();
        location.setName("Boletická");
        revizor.setCurrentLocation(location);
    }

    @Test
    public void exit() {
        assertEquals(true,suicide.exit());
    }
}