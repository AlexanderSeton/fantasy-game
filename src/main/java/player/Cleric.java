package player;

import java.util.HashMap;

public class Cleric extends Player{

    private HashMap<String, Integer> healingTools;
    private String activeTool;

    public Cleric(String name, int hitPoints, int treasure, HashMap<String, Integer> healingTools) {
        super(name, hitPoints, treasure);
        this.healingTools = healingTools;
        this.activeTool = this.healingTools.keySet().toArray()[0].toString();
    }

    public String talk() {
        return "Eat my religion, you mother.";
    }

    public void changeHealingTool(String healingItemName) {
        if (this.healingTools.keySet().contains(healingItemName)) {
            this.activeTool = healingItemName;
        }
    }

    public HashMap<String, Integer> getHealingTools() {
        return this.healingTools;
    }

    public String getActiveTool() {
        return this.activeTool;
    }

    public void wrathOfGod(Player player){
        player.getHurt(20);
    }
}
