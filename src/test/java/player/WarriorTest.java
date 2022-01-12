package player;

import player.Barbarian;
import player.Dwarf;
import player.Knight;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class WarriorTest {

    private Barbarian barbarian;
    private Dwarf dwarf;
    private Knight knight;

    @Before 
    public void before() {

        HashMap<String, Integer> weapons = new HashMap<>();
        weapons.put("sword", 27);
        weapons.put("hammer", 15);
        // name, hitPoints, treasure, weapons, activeWeapon
        barbarian = new Barbarian("Conan", 100, 0, weapons);
        dwarf = new Dwarf("Ian", 100, 0, weapons);
        knight = new Knight("Arthur", 100, 0, weapons);
    }
    
    @Test
    public void hasName() {
        assertEquals("Arthur", knight.getName());
        assertEquals("Conan", barbarian.getName());
        assertEquals("Ian", dwarf.getName());
    }

    @Test
    public void hasHitPoints() {
        assertEquals(100, knight.getHitPoints());
        assertEquals(100, barbarian.getHitPoints());
        assertEquals(100, dwarf.getHitPoints());
    }

    @Test
    public void hasTreasure() {
        assertEquals(0, knight.getTreasure());
        assertEquals(0, barbarian.getTreasure());
        assertEquals(0, dwarf.getTreasure());
    }

    @Test
    public void hasXP() {
        assertEquals(0, knight.getExperiencePoints());
        assertEquals(0, barbarian.getExperiencePoints());
        assertEquals(0, dwarf.getExperiencePoints());
    }
    
    @Test
    public void hasWeapons() {
        assertEquals(2, knight.getWeapons().size());
        assertEquals(2, barbarian.getWeapons().size());
        assertEquals(2, dwarf.getWeapons().size());
    }

    @Test
    public void hasActiveWeapon() {
        assertEquals("sword", knight.getActiveWeapon());
        assertEquals("sword", barbarian.getActiveWeapon());
        assertEquals("sword", dwarf.getActiveWeapon());
    }
}
