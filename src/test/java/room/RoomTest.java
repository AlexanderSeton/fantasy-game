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
    private Room room2;
    private Room room3;
    private Knight knight;

    @Before
    public void before() {
        HashMap<String, Integer> weapons = new HashMap<>();
        weapons.put("sword", 25);
        weapons.put("hammer", 15);
        knight = new Knight("Arthur", 100, 0, weapons);
        Enemy enemy = new Enemy("Ogre", 20, 10);
        Enemy enemy2 = new Enemy("Dragon", 75, 30);
        Enemy enemy3 = new Enemy("Alien Queen", 1000, 50);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(enemy);
        ArrayList<Enemy> enemies2 = new ArrayList<>();
        enemies2.add(enemy);
        enemies2.add(enemy2);
        ArrayList<Enemy> enemies3 = new ArrayList<>();
        enemies3.add(enemy);
        enemies3.add(enemy2);
        enemies3.add(enemy3);
        room = new Room(1, "Dungeon", 50, enemies, knight);
        room2 = new Room(1, "Dungeon", 100, enemies2, knight);
        room3 = new Room(1, "Dungeon", 150, enemies3, knight);
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
        assertEquals(100, knight.getHitPoints());
    }

    @Test
    public void playerCanBeatTwoEnemies() {
        
        room2.playRoom(knight);
        assertEquals(40, knight.getHitPoints());
    }

    @Test
    public void roomCanBeLost() {
        room3.playRoom(knight);
        assertEquals(false, knight.getAlive());
    }

    @Test
    public void playerHasTreasureAfterCompletion() {
        room.playRoom(knight);
        assertEquals(50, knight.getTreasure());
    }
}
