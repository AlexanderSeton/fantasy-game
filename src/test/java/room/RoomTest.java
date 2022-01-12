package room;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.text.PlainDocument;

import org.junit.Before;
import org.junit.Test;

import player.Knight;
import player.Player;
import room.Room;
import room.enemy.Enemy;

public class RoomTest{

    private Room room;
    private Knight knight;

    @Before
    public void before() {
        HashMap<String, Integer> weapons = new HashMap<>();
        weapons.put("sword", 25);
        weapons.put("hammer", 15);
        knight = new Knight("Arthur", 100, 0, weapons);
        Enemy enemy = new Enemy("Ogre", 100, 10);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);
        room = new Room(1, "Dungeon", 50, enemies, knight);
    }

    @Test
    public void hasLevel() {
        assertEquals(1, room.getLevel());
    }

    @Test
    public void hasName() {
        assertEquals("Dungeon", room.getName());
    }

    @Test
    public void hasTreasureAmount() {
        assertEquals(50, room.getTreasureAmount());
    }

    @Test
    public void hasEnemies() {
        assertEquals(1, room.getEnemies().size());
    }

    @Test
    public void hasCompleted() {
        assertEquals(false, room.getCompleted());
    }

    @Test
    public void roomCanBePlayed() {
        room.playRoom(knight);
        assertEquals(70, knight.getHitPoints());
    }

    @Test
    public void playerHasTreasureAfterCompletion() {
        room.playRoom(knight);
        assertEquals(50, knight.getTreasure());
    }
}
