import static org.junit.Assert.assertEquals;

import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import player.Knight;
import player.Cleric;
import player.Player;
import room.Room;
import room.enemy.Enemy;


public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Room room1;
    private Room room2;
    ArrayList<Room> rooms;

    @Before
    public void before() {
        // player
        HashMap<String, Integer> weapons = new HashMap<>();
        weapons.put("sword", 27);
        weapons.put("hammer", 15);
        player1 = new Knight("Arthur", 9000, 0, weapons);
        HashMap<String, Integer> healingTools = new HashMap<String, Integer>();
        healingTools.put("potion", 25);
        healingTools.put("bandage", 15);
        player2 = new Cleric("Roger", 200, 0, healingTools);
        // rooms
        Enemy enemy = new Enemy("Ogre", 20, 10);
        Enemy enemy2 = new Enemy("Dragon", 75, 30);
        Enemy enemy3 = new Enemy("Alien Queen", 200, 50);
        ArrayList<Enemy> enemies1 = new ArrayList<>();
        enemies1.add(enemy);
        enemies1.add(enemy2);
        ArrayList<Enemy> enemies2 = new ArrayList<>();
        enemies2.add(enemy);
        enemies2.add(enemy2);
        enemies2.add(enemy3);
        rooms = new ArrayList<Room>();
        room1 = new Room(1, "Dungeon", 50, enemies1);
        room2 = new Room(2, "Dungeon", 100, enemies2);
        rooms.add(room1);
        rooms.add(room2);

    }

    @Test
    public void hasRooms() {
        game = new Game(rooms, player1);
        assertEquals(rooms, game.getRooms());
    }
    
    @Test
    public void hasPlayer() {
        game = new Game(rooms, player1);
        assertEquals(player1, game.getPlayer());
    }
    
    @Test
    public void canPlayGame() {
        game = new Game(rooms, player1);
        System.out.println(game.play());
    }


    @Test
    public void canPlayAndLose() {
        game = new Game(rooms, player2);
        System.out.println(game.play());
    }
}
