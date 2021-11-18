package animalgame;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is the SavedGame Class that we use for saving games in progress.
 * @author Dino Vejzovic, Carl Lander, Perin Koriea
 */

public class SavedGame implements Serializable {
    private ArrayList<Player> players;
    private int lastRoundPlayed;
    private int rounds;


    //Constructor
    public SavedGame(ArrayList<Player> players, int lastRoundPlayed, int rounds){
        this.players = players;
        this.lastRoundPlayed = lastRoundPlayed;
        this.rounds = rounds;
    }

    /**
     * Method for getting the players that are stored in the playerList
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Method for getting the last round when the player saved the game.
     */

    public int getLastRoundPlayed() {
        return lastRoundPlayed;
    }
    /**
     * Method for getting the amount of rounds that where initialized.
     */
    public int getRounds() {
        return rounds;
    }
}
