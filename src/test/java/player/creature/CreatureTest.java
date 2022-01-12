package player.creature;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreatureTest {

    private Creature creature;

    @Before
    public void before() {
        creature = new Creature("Dragon", 50);
    }

    @Test
    public void hasName() {
        assertEquals("Dragon", creature.getName());
    }

    @Test
    public void hasHealth() {
        assertEquals(50, creature.getHealth());
    }

    @Test
    public void canDecreaseHealth() {
        creature.decreaseHealth(10);
        assertEquals(40, creature.getHealth());
    }

    @Test
    public void canCheckIfAlive() {
        assertEquals(true, creature.getAlive());
        creature.decreaseHealth(140);
        assertEquals(false, creature.getAlive());
    }
}
