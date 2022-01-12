package player;

public abstract class Player {
    private String name;
    private int hitPoints;
    private int experiencePoints;
    private int treasure;
    private boolean alive;

    public Player(String name, int hitPoints, int treasure) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.experiencePoints = 0;
        this.treasure = treasure;
        this.alive = true;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoints() {
        return this.hitPoints;
    }

    public int getExperiencePoints() {
        return this.experiencePoints;
    }

    public int getTreasure() {
        return this.treasure;
    }

      public boolean getAlive() {
        return this.alive;
    }

    public abstract String talk();

    public void getHurt(int damage) {
        this.hitPoints -= damage;
        this.checkAlive();
    }

    public void getHealed(int heal) {
        this.hitPoints += heal;
    }

    public void checkAlive() {
        if (this.hitPoints <= 0) {
            this.alive = false;
        }
    }
}
