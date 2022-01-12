package player;

import player.creature.Creature;

import java.util.HashMap;

public abstract class Magician extends Player{
    private Creature creature;
    private HashMap<String, Integer> spells;

    public Magician(String name, int hitPoints, int treasure, Creature creature, HashMap<String, Integer> spells) {
        super(name, hitPoints, treasure);
        this.creature = creature;
        this.spells = spells;
    }


    
}
