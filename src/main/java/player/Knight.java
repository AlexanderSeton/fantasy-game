package player;

import java.util.HashMap;

public class Knight extends Warrior {

    public Knight(String name, int hitPoints, int treasure, HashMap<String, Integer> weapons) {
        super(name, hitPoints, treasure, weapons);
    }

    public String talk() {
        return "I am a knight";
    }
}
