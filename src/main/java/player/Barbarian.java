package player;

import java.util.HashMap;

public class Barbarian extends Warrior {

    public Barbarian(String name, int hitPoints, int treasure, HashMap<String, Integer> weapons) {
        super(name, hitPoints, treasure, weapons);
    }

    public String talk() {
        return "I am a barbarian";
    }
}
