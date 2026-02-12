package commands;

import code.Revizor;
import code.Tools;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BagTest {

    Revizor revizor1;
    Revizor revizor2;
    Bag bag1;
    Bag bag2;

    @Before
    public void setUp() throws Exception {
        revizor1 = new Revizor();
        revizor1.setMoney(100);
        bag1 = new Bag(revizor1);

        revizor2 = new Revizor();
        revizor2.setMoney(-5);
        bag2 = new Bag(revizor2);
    }

    @Test
    public void wallet() {
        assertEquals(Tools.color("yellow", 100 + "kč"),bag1.wallet());
        assertEquals(Tools.color("red", -5 + "kč"),bag2.wallet());
    }
}