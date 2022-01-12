package player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.sound.sampled.SourceDataLine;

import org.junit.Before;
import org.junit.Test;
import player.creature.Creature;

public class WizardTest {
    
    private Wizard wizard;
    private Creature creature;
    private Creature creature2;

    @Before
    public void before() {
        creature = new Creature("Dragon", 50);
        creature2 = new Creature("Ogre", 20);
        ArrayList<Creature> creatures = new ArrayList<>();
        creatures.add(creature);
        creatures.add(creature2);
        HashMap<String, Integer> spells = new HashMap<String, Integer>();
        spells.put("abra", 25);
        spells.put("cadabra", 15);
        spells.put("Fireball", 35);
        spells.put("Lightning Strike", 55);
        wizard = new Wizard("Merlin", 100, 100, creatures, spells);
    }
    
    @Test
    public void hasName() {
        assertEquals("Merlin", wizard.getName());
    }

    @Test
    public void hasHitPoints() {
        assertEquals(100, wizard.getHitPoints());
    }

    @Test
    public void hasTreasure() {
        assertEquals(100, wizard.getTreasure());
    }

    @Test
    public void hasXP() {
        assertEquals(0, wizard.getExperiencePoints());
    }

    @Test
    public void hasSpells() {
        assertEquals(4, wizard.getSpells().size());
    }

    @Test
    public void hasCreatures() {
        assertEquals(2, wizard.getCreatures().size());
    }

    @Test
    public void hasActiveCreature() {
        assertTrue(wizard.getActiveCreature() instanceof Creature);
    }

    @Test
    public void creatureAbsorbsDamage() {
        wizard.sustainDamage(50);
        assertEquals(100, wizard.getHitPoints());
    }

    @Test
    public void creatureSwapsIfDead() {
        wizard.sustainDamage(60);
        assertEquals(creature2.getName(), wizard.getActiveCreature().getName());
    }

    @Test
    public void wizardDamagedAfterCreatures() {
        wizard.sustainDamage(50);
        wizard.sustainDamage(30);
        wizard.sustainDamage(10);
        assertEquals(90, wizard.getHitPoints());
    }

    @Test
    public void canCastSpell() {
        wizard.cast("Fireball", wizard);
        assertEquals(65, wizard.getHitPoints());
    }
}
