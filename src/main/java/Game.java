import java.util.ArrayList;

import javax.xml.ws.handler.MessageContext;

import player.Player;
import room.Room;

public class Game {

    private ArrayList<Room> rooms;
    private Player player;

    public Game(ArrayList<Room> rooms, Player player) {
        this.rooms = rooms;
        this.player = player;
    }

    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public Player getPlayer() {
        return this.player;
    }

    public String play() {
        boolean won = true;
        for (int i=0; i<this.rooms.size(); i++){
            Room currentRoom = this.rooms.get(i);
            currentRoom.playRoom(this.player);
            if (currentRoom.getCompleted() == false) {
                won = false;
                break;
            }
        }
        String message;
        if (won == true) {
            message = new StringBuilder()
            .append("Congratulations, " + this.player.getName() + ", you have won!\n")
            .append("Score: " + this.player.getTreasure() + "\n")
            .append("Health Remaining: " + this.player.getHitPoints() + "\n")
            .append("Character: " + this.player.getClass().toString().substring(13) + "\n")
            .append("\n")
            .toString();
        }
        else {
            message = new StringBuilder()
            .append("You fought valiantly, " + this.player.getName() + ", but you lost and the kingdom is in tatters. \n")
            .append("Your score is " + this.player.getTreasure() + "! \n")
            .append("Player Type: " + this.player.getClass().toString().substring(13))
            .append("\n")
            .toString();
        }
        return message;
    }
}
