package room.enemy;

import player.Magician;
import player.Player;

public class Enemy {
    private String name;
    private int hitPoints;
    private boolean alive;
    private int damageAmount;

    public Enemy(String name, int hitPoints, int damageAmount) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.alive = true;
        this.damageAmount = damageAmount;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public int getDamageAmount() {
        return this.damageAmount;
    }

    public void attack(Player player) {
        if (player instanceof Magician) {
            ((Magician) player).sustainDamage(this.damageAmount);
        }
        else {
            player.getHurt(damageAmount);
        }
    }

    public void getHurt(int damage) {
        this.hitPoints -= damage;
        this.checkAlive();
    }

    public void checkAlive() {
        if (this.hitPoints <= 0) {
            this.alive = false;
        }
    }
}
