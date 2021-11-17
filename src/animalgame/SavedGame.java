package animalgame;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedGame implements Serializable {
    private ArrayList<Player> players;
    private int lastRoundPlayed;
    private int rounds;


    public SavedGame(ArrayList<Player> players, int lastRoundPlayed, int rounds){
        this.players = players;
        this.lastRoundPlayed = lastRoundPlayed;
        this.rounds = rounds;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int getLastRoundPlayed() {
        return lastRoundPlayed;
    }

    public int getRounds() {
        return rounds;
    }
}
