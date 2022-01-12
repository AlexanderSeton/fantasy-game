package room.enemy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import room.enemy.Enemy;
import player.Knight;

public class EnemyTest {

    private Enemy enemy;
    private Knight knight;

    @Before
    public void before() {
        HashMap<String, Integer> weapons = new HashMap<>();
        weapons.put("sword", 20);
        enemy = new Enemy("Smaug", 50, 15);
        knight = new Knight("Arthur", 100, 100, weapons); 
    }

    @Test
    public void hasName() {
        assertEquals("Smaug", enemy.getName());
    }

    @Test
    public void hasHitPoints() {
        assertEquals(50, enemy.getHitPoints());
    }
    
    @Test
    public void hasDamageAmount() {
        assertEquals(15, enemy.getDamageAmount());
    }

    @Test
    public void hasAlive() {
        assertEquals(true, enemy.getAlive());
    }

    @Test
    public void canAttackPlayer() {
        enemy.attack(knight);
        assertEquals(85, knight.getHitPoints());
    }

    @Test
    public void canGetHurt() {
        knight.fight(enemy);
        assertEquals(30, enemy.getHitPoints());
    }
}
