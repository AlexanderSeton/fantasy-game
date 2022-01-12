package player;

import java.util.HashMap;

public class Dwarf extends Warrior {

    public Dwarf(String name, int hitPoints, int treasure, HashMap<String, Integer> weapons) {
        super(name, hitPoints, treasure, weapons);
    }

    public String talk() {
        return "I am a dwarf";
    }
}
