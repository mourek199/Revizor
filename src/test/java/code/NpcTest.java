package code;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NpcTest {

    Npc npc;

    @Before
    public void setUp() throws Exception {
        npc = new Npc();
        npc.setName("mari");
        npc.setWelcomeMessage("zdravim :)");
    }

    @Test
    public void getWelcomeMessage() {
        assertEquals("mari" +": \"" +"zdravim :)" +"\"",npc.getWelcomeMessage());
    }
}