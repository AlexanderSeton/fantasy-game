package player;

import player.creature.Creature;
import room.enemy.Enemy;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.sampled.SourceDataLine;

public abstract class Magician extends Player{
    private ArrayList<Creature> creatures;
    private Creature activeCreature;
    private HashMap<String, Integer> spells;

    public Magician(String name, int hitPoints, int treasure, ArrayList<Creature> creatures, HashMap<String, Integer> spells) {
        super(name, hitPoints, treasure);
        this.creatures = creatures;
        this.spells = spells;
        this.activeCreature = this.setActiveCreature(creatures);
    }

    public Creature setActiveCreature(ArrayList<Creature> creatures) {
        if (creatures.size() == 0) {
            this.activeCreature =  null;
            return null;
        }
        else {
            this.activeCreature = creatures.get(0);
            return creatures.get(0);
        }
    }

    public ArrayList<Creature> getCreature() {
        return this.creatures;
    }

    public HashMap<String, Integer> getSpells() {
        return this.spells;
    }

    public Creature getActiveCreature() {
        return this.activeCreature;
    }

    public ArrayList<Creature> getCreatures() {
        return this.creatures;
    }

    public void sustainDamage(int damage) {
        if (this.activeCreature != null) {
            this.activeCreature.decreaseHealth(damage);
        }
        else {
            this.getHurt(damage);
        }
        this.checkCreatures();
    }

    public void checkCreatures() {
        if (this.activeCreature != null) {
            if (this.activeCreature.getAlive() == false) {
                this.creatures.remove(this.activeCreature);
                this.setActiveCreature(this.creatures);
            }
        }
    }

    public void cast(String spell, Enemy enemy) {
        int damage = this.spells.get(spell);
        enemy.getHurt(damage);
    }
}
