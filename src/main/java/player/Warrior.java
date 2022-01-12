package player;

import java.util.HashMap;

import room.enemy.Enemy;

public abstract class Warrior extends Player {

    private HashMap<String, Integer> weapons;
    private String activeWeapon;
   
    public Warrior(String name, int hitPoints, int treasure, HashMap<String, Integer> weapons) {
        super(name, hitPoints, treasure);
        this.weapons = weapons;
        this.activeWeapon = this.setActiveWeapon(weapons);
    }

    public String setActiveWeapon(HashMap<String, Integer> weapons) {
        if (weapons.size() == 0) {
            this.activeWeapon = null;
            return null;
        }
        else {
            this.activeWeapon = weapons.keySet().toArray()[0].toString();
            return weapons.keySet().toArray()[0].toString();
        }
    }

    public HashMap<String, Integer> getWeapons() {
        return this.weapons;
    }

    public String getActiveWeapon() {
        return this.activeWeapon;
    }

    public void fight(Enemy enemy) {
        int damage = weapons.get(activeWeapon);
        enemy.getHurt(damage);
    }
}
