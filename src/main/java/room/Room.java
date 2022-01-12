package room;

import player.Magician;
import room.enemy.Enemy;

import java.util.ArrayList;

import javax.sound.sampled.SourceDataLine;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import player.Cleric;
import player.Player;
import player.Warrior;

public class Room {

    private String name;
    private int treasureAmount;
    private ArrayList<Enemy> enemies;
    private Player player;
    private int level;
    private boolean completed;

    public Room(int level, String name, int treasureAmount, ArrayList<Enemy> enemies, Player player) {
        this.name = name;
        this.treasureAmount = treasureAmount;
        this.enemies = enemies;
        this.player = player;
        this.level = level;
        this.completed = false;
    }

    public String getName() {
        return this.name;
    }

    public int getTreasureAmount() {
        return this.treasureAmount;
    }

    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted() {
        this.completed = true;
    }

    public void playRoom(Player player) {
        for (int i=0; i<this.enemies.size(); i++) {
            Enemy currentEnemy = this.enemies.get(i);
            while (player.getAlive() && this.enemies.get(i).getAlive()) {
                // player attack
                if (player instanceof Cleric) {
                    ((Cleric) player).wrathOfGod(currentEnemy);
                }
                else if (player instanceof Warrior) {
                    ((Warrior) player).fight(currentEnemy);
                } else {
                    String spellName = ((Magician) player).getSpells().keySet().toArray()[0].toString();
                    ((Magician) player).cast(spellName, currentEnemy);
                }
                // enemy attack
                if (currentEnemy.getAlive()){
                    currentEnemy.attack(player);
                }   
            }
            if (player.getAlive() == false) {
                System.out.println("PLAYER DEAD");
                System.exit(0);
            }
        }
        // assign room as completed & give player room treasure
        this.setCompleted();
        player.addTreasure(this.getTreasureAmount());
        
    }

}
