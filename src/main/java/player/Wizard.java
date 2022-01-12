package player;

import player.creature.Creature;

import java.util.ArrayList;
import java.util.HashMap;

public class Wizard extends Magician {

    public Wizard(String name, int hitPoints, int treasure, ArrayList<Creature> creatures, HashMap<String, Integer> spells) {
        super(name, hitPoints, treasure, creatures, spells);
    }

    public String talk() {
        return "I'm a wizard";
    }
}
