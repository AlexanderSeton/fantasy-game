package player;

import org.junit.Before;
import org.junit.Test;
import room.enemy.Enemy;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ClericTest {
    
    private Cleric cleric;
    private Cleric cleric2;
    private Enemy enemy;

    @Before
    public void before() {
        HashMap<String, Integer> healingTools = new HashMap<String, Integer>();
        healingTools.put("potion", 25);
        healingTools.put("bandage", 15);
        cleric = new Cleric("Tom", 100, 0, healingTools);
        cleric2 = new Cleric("Ian", 100, 0, healingTools);
        enemy = new Enemy("Dragon", 100, 1500);
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
    public void canFight() {
        cleric.fight(enemy);
        assertEquals(80, enemy.getHitPoints());
    }
}
