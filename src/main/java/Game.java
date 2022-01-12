import java.util.ArrayList;

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
        if (won == true) {
            return "Congratulations you have won!\nScore: " + this.player.getTreasure() + "\nHealth Remaining: " + this.player.getHitPoints() + "\nPlayer type: " + this.player.getClass();
        }
        else {
            return "You fought valiantly, " + this.player.getName() + ", but you lost and the kingdom is in tatters. \n Your score is " + this.player.getTreasure() + "! \n Player Type: " + this.player.getClass();
        }
    }

}
