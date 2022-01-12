package player.creature;

public class Creature {
    private String name;
    private int health;
    private boolean alive;

    public Creature(String name, int health) {
        this.name = name;
        this.health = health;
        this.alive = true;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public boolean getAlive() {
        return this.alive;
    }

    public void decreaseHealth(int damage) {
        this.health -= damage;
        this.checkAlive();
    }

    public void checkAlive() {
        if (this.health <= 0) {
            this.alive = false;
        }
    }
}
