package player;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ClericTest {
    
    private Cleric cleric;
    private Cleric cleric2;

    @Before
    public void before() {
        HashMap<String, Integer> healingTools = new HashMap<String, Integer>();
        healingTools.put("potion", 25);
        healingTools.put("bandage", 15);
        cleric = new Cleric("Tom", 100, 0, healingTools);
        cleric2 = new Cleric("Ian", 100, 0, healingTools);
    }

    @Test
    public void hasName() {
        assertEquals("Tom", cleric.getName());
    }

    @Test
    public void hasHitPoints() {
        assertEquals(100, cleric.getHitPoints());
    }

    @Test
    public void hasTreasure() {
        assertEquals(0, cleric.getTreasure());
    }

    @Test
    public void hasXP() {
        assertEquals(0, cleric.getExperiencePoints());
    }

    @Test
    public void hasHealingTools() {
        assertEquals(2, cleric.getHealingTools().size());
    }

    @Test
    public void hasActiveTool() {
        assertEquals("potion", cleric.getActiveTool());
    }

    @Test
    public void hasWrathOfGod() {
//        cleric.wrathOfGod(cleric2);
//        assertEquals(80, cleric2.getHitPoints());
    }
}
